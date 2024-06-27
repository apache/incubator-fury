# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

import numpy as np

from pyfury.meta.encoding import Encoding, Short_MAX_VALUE
from pyfury.meta.metastring import MetaString
from pyfury.utils.preconditions import Preconditions


# Encodes plain text strings into MetaString objects with specified encoding mechanisms.
class MetaStringEncoder:
    def __init__(self, special_char1, special_char2):
        self.special_char1 = special_char1
        self.special_char2 = special_char2

    def encode(self, input_string):
        Preconditions.check_argument(
            len(input_string) < Short_MAX_VALUE,
            "Long meta string than 32767 is not allowed",
        )
        if not input_string:
            return MetaString(
                input_string,
                Encoding.UTF_8,
                self.special_char1,
                self.special_char2,
                np.array([], np.uint8),
                0,
            )

        encoding = self.compute_encoding(input_string)
        return self.encode_with_encoding(input_string, encoding)

    def encode_with_encoding(self, input_string, encoding):
        Preconditions.check_argument(
            len(input_string) < Short_MAX_VALUE,
            "Long meta string than 32767 is not allowed",
        )
        if not input_string:
            return MetaString(
                input_string,
                Encoding.UTF_8,
                self.special_char1,
                self.special_char2,
                np.array([], np.uint8),
                0,
            )

        length = len(input_string)
        if encoding == Encoding.LOWER_SPECIAL:
            encoded_data = self._encode_lower_special(input_string)
            return MetaString(
                input_string,
                encoding,
                self.special_char1,
                self.special_char2,
                encoded_data,
                length * 5,
            )
        elif encoding == Encoding.LOWER_UPPER_DIGIT_SPECIAL:
            encoded_data = self._encode_lower_upper_digit_special(input_string)
            return MetaString(
                input_string,
                encoding,
                self.special_char1,
                self.special_char2,
                encoded_data,
                length * 6,
            )
        elif encoding == Encoding.FIRST_TO_LOWER_SPECIAL:
            encoded_data = self._encode_first_to_lower_special(input_string)
            return MetaString(
                input_string,
                encoding,
                self.special_char1,
                self.special_char2,
                encoded_data,
                length * 5,
            )
        elif encoding == Encoding.ALL_TO_LOWER_SPECIAL:
            chars = list(input_string)
            upper_count = sum(1 for c in chars if c.isupper())
            encoded_data = self._encode_all_to_lower_special(chars, upper_count)
            return MetaString(
                input_string,
                encoding,
                self.special_char1,
                self.special_char2,
                encoded_data,
                (upper_count + length) * 5,
            )
        else:
            encoded_data = np.frombuffer(input_string.encode("utf-8"), dtype=np.uint8)
            return MetaString(
                input_string,
                Encoding.UTF_8,
                self.special_char1,
                self.special_char2,
                encoded_data,
                len(encoded_data) * 8,
            )

    def compute_encoding(self, input_string):
        if not input_string:
            return Encoding.LOWER_SPECIAL

        chars = list(input_string)
        statistics = self._compute_statistics(chars)
        if statistics["can_lower_special_encoded"]:
            return Encoding.LOWER_SPECIAL
        elif statistics["can_lower_upper_digit_special_encoded"]:
            if statistics["digit_count"] != 0:
                return Encoding.LOWER_UPPER_DIGIT_SPECIAL
            else:
                upper_count = statistics["upper_count"]
                if upper_count == 1 and chars[0].isupper():
                    return Encoding.FIRST_TO_LOWER_SPECIAL
                if (len(chars) + upper_count) * 5 < len(chars) * 6:
                    return Encoding.ALL_TO_LOWER_SPECIAL
                else:
                    return Encoding.LOWER_UPPER_DIGIT_SPECIAL
        return Encoding.UTF_8

    def _compute_statistics(self, chars):
        can_lower_upper_digit_special_encoded = True
        can_lower_special_encoded = True
        digit_count = 0
        upper_count = 0
        for c in chars:
            if can_lower_upper_digit_special_encoded:
                if not (
                    c.islower()
                    or c.isupper()
                    or c.isdigit()
                    or c == self.special_char1
                    or c == self.special_char2
                ):
                    can_lower_upper_digit_special_encoded = False
            if can_lower_special_encoded:
                if not (c.islower() or c in {".", "_", "$", "|"}):
                    can_lower_special_encoded = False
            if c.isdigit():
                digit_count += 1
            if c.isupper():
                upper_count += 1
        return {
            "digit_count": digit_count,
            "upper_count": upper_count,
            "can_lower_special_encoded": can_lower_special_encoded,
            "can_lower_upper_digit_special_encoded": can_lower_upper_digit_special_encoded,
        }

    def _encode_lower_special(self, input_string):
        return self._encode_generic(input_string, 5)

    def _encode_lower_upper_digit_special(self, input_string):
        return self._encode_generic(input_string, 6)

    def _encode_first_to_lower_special(self, input_string):
        chars = list(input_string)
        chars[0] = chars[0].lower()
        return self._encode_generic(chars, 5)

    def _encode_all_to_lower_special(self, chars, upper_count):
        new_chars = []
        for c in chars:
            if c.isupper():
                new_chars.append("|")
                new_chars.append(c.lower())
            else:
                new_chars.append(c)
        return self._encode_generic(new_chars, 5)

    def _encode_generic(self, chars, bits_per_char):
        total_bits = len(chars) * bits_per_char + 1
        byte_length = (total_bits + 7) // 8
        bytes_array = bytearray(byte_length)
        current_bit = 1
        for c in chars:
            value = self._char_to_value(c, bits_per_char)
            for i in range(bits_per_char - 1, -1, -1):
                if (value & (1 << i)) != 0:
                    byte_pos = current_bit // 8
                    bit_pos = current_bit % 8
                    bytes_array[byte_pos] |= 1 << (7 - bit_pos)
                current_bit += 1
        strip_last_char = len(bytes_array) * 8 >= total_bits + bits_per_char
        if strip_last_char:
            bytes_array[0] = bytes_array[0] | 0x80
        return bytes_array

    def _char_to_value(self, c, bits_per_char):
        if bits_per_char == 5:
            if "a" <= c <= "z":
                return ord(c) - ord("a")
            elif c == ".":
                return 26
            elif c == "_":
                return 27
            elif c == "$":
                return 28
            elif c == "|":
                return 29
            else:
                raise ValueError(
                    f"Unsupported character for LOWER_SPECIAL encoding: {c}"
                )
        elif bits_per_char == 6:
            if "a" <= c <= "z":
                return ord(c) - ord("a")
            elif "A" <= c <= "Z":
                return 26 + (ord(c) - ord("A"))
            elif "0" <= c <= "9":
                return 52 + (ord(c) - ord("0"))
            elif c == self.special_char1:
                return 62
            elif c == self.special_char2:
                return 63
            else:
                raise ValueError(
                    f"Unsupported character for LOWER_UPPER_DIGIT_SPECIAL encoding: {c}"
                )