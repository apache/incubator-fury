/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.fury.io;

import java.io.InputStream;
import org.apache.fury.memory.MemoryBuffer;

/** A streaming reader to make {@link MemoryBuffer} to support streaming reading. */
public interface FuryStreamReader {
  /**
   * Read stream and fill the data to underlying {@link MemoryBuffer}, which is also the buffer
   * returned by {@link #getBuffer}.
   */
  int fillBuffer(int minFillSize);

  /**
   * Returns the underlying {@link MemoryBuffer}. This method will return same instance of buffer
   * for same {@link FuryStreamReader} instance.
   */
  MemoryBuffer getBuffer();

  /**
   * Create a {@link FuryInputStream} from the provided {@link InputStream}. Note that the provided
   * stream will be owned by the returned {@link FuryInputStream}, <bold>do not</bold> read the
   * provided {@link InputStream} anymore, read the returned stream instead.
   */
  static FuryInputStream of(InputStream stream) {
    return new FuryInputStream(stream);
  }
}
