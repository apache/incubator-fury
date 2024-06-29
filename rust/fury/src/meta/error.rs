// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

#[derive(thiserror::Error, Debug)]
pub enum Error {
    #[error("encoded_data cannot be empty")]
    EncodedDataEmpty,

    #[error("Long meta string than 32767 is not allowed")]
    LengthExceed,

    #[error("Non-ASCII characters in meta string are not allowed")]
    OnlyAllowASCII,

    #[error("Unsupported character for LOWER_SPECIAL encoding: {ch:?}")]
    UnsupportedLowerSpecialCharacter { ch: char },

    #[error("Unsupported character for LOWER_UPPER_DIGIT_SPECIAL encoding: {ch:?}")]
    UnsupportedLowerUpperDigitSpecialCharacter { ch: char },

    #[error("Invalid character value for LOWER_SPECIAL decoding: {value:?}")]
    InvalidLowerSpecialValue { value: u8 },

    #[error("Invalid character value for LOWER_UPPER_DIGIT_SPECIAL decoding: {value:?}")]
    InvalidLowerUpperDigitSpecialValue { value: u8 },
}
