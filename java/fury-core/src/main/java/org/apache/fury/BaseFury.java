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

package org.apache.fury;

import org.apache.fury.memory.MemoryBuffer;
import org.apache.fury.serializer.Serializer;
import org.apache.fury.serializer.Serializers;

/** All Fury’s basic interface, including Fury’s basic methods. */
public interface BaseFury {

  /**
   * register class.
   *
   * @param cls class to register.
   */
  void register(Class<?> cls);

  /**
   * Register class.
   *
   * @param cls class to register.
   * @param createSerializer whether to create serializer, if true and codegen enabled, this will
   *     generate the serializer code too.
   */
  void register(Class<?> cls, boolean createSerializer);

  /** register class with given id. */
  void register(Class<?> cls, Short id);

  /**
   * Register class with specified id.
   *
   * @param cls class to register.
   * @param id id for provided class.
   * @param createSerializer whether to create serializer, if true and codegen enabled, this will
   *     generate the serializer code too.
   */
  void register(Class<?> cls, Short id, boolean createSerializer);

  /**
   * Register a Serializer.
   *
   * @param type class needed to be serialized/deserialized.
   * @param serializerClass serializer class can be created with {@link Serializers#newSerializer}.
   * @param <T> type of class.
   */
  <T> void registerSerializer(Class<T> type, Class<? extends Serializer> serializerClass);

  /** Return serialized <code>obj</code> as a byte array. */
  byte[] serialize(Object obj);

  /**
   * Serialize <code>obj</code> to a off-heap buffer specified by <code>address</code> and <code>
   * size</code>.
   */
  MemoryBuffer serialize(Object obj, long address, int size);

  /** Serialize data into buffer. */
  MemoryBuffer serialize(MemoryBuffer buffer, Object obj);

  /** Deserialize <code>obj</code> from a byte array. */
  Object deserialize(byte[] bytes);

  /**
   * Deserialize <code>obj</code> from a off-heap buffer specified by <code>address</code> and
   * <code>size</code>.
   */
  Object deserialize(long address, int size);

  /** Deserialize <code>obj</code> from a <code>buffer</code>. */
  Object deserialize(MemoryBuffer buffer);

  /**
   * Serialize java object without class info, deserialization should use {@link
   * #deserializeJavaObject}.
   */
  byte[] serializeJavaObject(Object obj);

  /**
   * Serialize java object without class info, deserialization should use {@link
   * #deserializeJavaObject}.
   */
  void serializeJavaObject(MemoryBuffer buffer, Object obj);

  /**
   * Deserialize java object from binary without class info, serialization should use {@link
   * #serializeJavaObject}.
   */
  <T> T deserializeJavaObject(byte[] data, Class<T> cls);

  /**
   * Deserialize java object from binary by passing class info, serialization should use {@link
   * #serializeJavaObject}.
   */
  <T> T deserializeJavaObject(MemoryBuffer buffer, Class<T> cls);
}
