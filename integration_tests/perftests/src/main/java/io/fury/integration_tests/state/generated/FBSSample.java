// automatically generated by the FlatBuffers compiler, do not modify

package org.apache.fury.integration_tests.state.generated;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class FBSSample extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_2_0_0(); }
  public static FBSSample getRootAsFBSSample(ByteBuffer _bb) { return getRootAsFBSSample(_bb, new FBSSample()); }
  public static FBSSample getRootAsFBSSample(ByteBuffer _bb, FBSSample obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public FBSSample __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int intValue() { int o = __offset(4); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public long longValue() { int o = __offset(6); return o != 0 ? bb.getLong(o + bb_pos) : 0L; }
  public float floatValue() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public double doubleValue() { int o = __offset(10); return o != 0 ? bb.getDouble(o + bb_pos) : 0.0; }
  public short shortValue() { int o = __offset(12); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public short charValue() { int o = __offset(14); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public boolean booleanValue() { int o = __offset(16); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public int intValueBoxed() { int o = __offset(18); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public long longValueBoxed() { int o = __offset(20); return o != 0 ? bb.getLong(o + bb_pos) : 0L; }
  public float floatValueBoxed() { int o = __offset(22); return o != 0 ? bb.getFloat(o + bb_pos) : 0.0f; }
  public double doubleValueBoxed() { int o = __offset(24); return o != 0 ? bb.getDouble(o + bb_pos) : 0.0; }
  public short shortValueBoxed() { int o = __offset(26); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public short charValueBoxed() { int o = __offset(28); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public boolean booleanValueBoxed() { int o = __offset(30); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public int intArray(int j) { int o = __offset(32); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int intArrayLength() { int o = __offset(32); return o != 0 ? __vector_len(o) : 0; }
  public IntVector intArrayVector() { return intArrayVector(new IntVector()); }
  public IntVector intArrayVector(IntVector obj) { int o = __offset(32); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer intArrayAsByteBuffer() { return __vector_as_bytebuffer(32, 4); }
  public ByteBuffer intArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 32, 4); }
  public long longArray(int j) { int o = __offset(34); return o != 0 ? bb.getLong(__vector(o) + j * 8) : 0; }
  public int longArrayLength() { int o = __offset(34); return o != 0 ? __vector_len(o) : 0; }
  public LongVector longArrayVector() { return longArrayVector(new LongVector()); }
  public LongVector longArrayVector(LongVector obj) { int o = __offset(34); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer longArrayAsByteBuffer() { return __vector_as_bytebuffer(34, 8); }
  public ByteBuffer longArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 34, 8); }
  public float floatArray(int j) { int o = __offset(36); return o != 0 ? bb.getFloat(__vector(o) + j * 4) : 0; }
  public int floatArrayLength() { int o = __offset(36); return o != 0 ? __vector_len(o) : 0; }
  public FloatVector floatArrayVector() { return floatArrayVector(new FloatVector()); }
  public FloatVector floatArrayVector(FloatVector obj) { int o = __offset(36); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer floatArrayAsByteBuffer() { return __vector_as_bytebuffer(36, 4); }
  public ByteBuffer floatArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 36, 4); }
  public double doubleArray(int j) { int o = __offset(38); return o != 0 ? bb.getDouble(__vector(o) + j * 8) : 0; }
  public int doubleArrayLength() { int o = __offset(38); return o != 0 ? __vector_len(o) : 0; }
  public DoubleVector doubleArrayVector() { return doubleArrayVector(new DoubleVector()); }
  public DoubleVector doubleArrayVector(DoubleVector obj) { int o = __offset(38); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer doubleArrayAsByteBuffer() { return __vector_as_bytebuffer(38, 8); }
  public ByteBuffer doubleArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 38, 8); }
  public short shortArray(int j) { int o = __offset(40); return o != 0 ? bb.getShort(__vector(o) + j * 2) : 0; }
  public int shortArrayLength() { int o = __offset(40); return o != 0 ? __vector_len(o) : 0; }
  public ShortVector shortArrayVector() { return shortArrayVector(new ShortVector()); }
  public ShortVector shortArrayVector(ShortVector obj) { int o = __offset(40); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer shortArrayAsByteBuffer() { return __vector_as_bytebuffer(40, 2); }
  public ByteBuffer shortArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 40, 2); }
  public short charArray(int j) { int o = __offset(42); return o != 0 ? bb.getShort(__vector(o) + j * 2) : 0; }
  public int charArrayLength() { int o = __offset(42); return o != 0 ? __vector_len(o) : 0; }
  public ShortVector charArrayVector() { return charArrayVector(new ShortVector()); }
  public ShortVector charArrayVector(ShortVector obj) { int o = __offset(42); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer charArrayAsByteBuffer() { return __vector_as_bytebuffer(42, 2); }
  public ByteBuffer charArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 42, 2); }
  public boolean booleanArray(int j) { int o = __offset(44); return o != 0 ? 0!=bb.get(__vector(o) + j * 1) : false; }
  public int booleanArrayLength() { int o = __offset(44); return o != 0 ? __vector_len(o) : 0; }
  public BooleanVector booleanArrayVector() { return booleanArrayVector(new BooleanVector()); }
  public BooleanVector booleanArrayVector(BooleanVector obj) { int o = __offset(44); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer booleanArrayAsByteBuffer() { return __vector_as_bytebuffer(44, 1); }
  public ByteBuffer booleanArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 44, 1); }
  public String string() { int o = __offset(46); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer stringAsByteBuffer() { return __vector_as_bytebuffer(46, 1); }
  public ByteBuffer stringInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 46, 1); }

  public static int createFBSSample(FlatBufferBuilder builder,
      int int_value,
      long long_value,
      float float_value,
      double double_value,
      short short_value,
      short char_value,
      boolean boolean_value,
      int int_value_boxed,
      long long_value_boxed,
      float float_value_boxed,
      double double_value_boxed,
      short short_value_boxed,
      short char_value_boxed,
      boolean boolean_value_boxed,
      int int_arrayOffset,
      int long_arrayOffset,
      int float_arrayOffset,
      int double_arrayOffset,
      int short_arrayOffset,
      int char_arrayOffset,
      int boolean_arrayOffset,
      int stringOffset) {
    builder.startTable(22);
    FBSSample.addDoubleValueBoxed(builder, double_value_boxed);
    FBSSample.addLongValueBoxed(builder, long_value_boxed);
    FBSSample.addDoubleValue(builder, double_value);
    FBSSample.addLongValue(builder, long_value);
    FBSSample.addString(builder, stringOffset);
    FBSSample.addBooleanArray(builder, boolean_arrayOffset);
    FBSSample.addCharArray(builder, char_arrayOffset);
    FBSSample.addShortArray(builder, short_arrayOffset);
    FBSSample.addDoubleArray(builder, double_arrayOffset);
    FBSSample.addFloatArray(builder, float_arrayOffset);
    FBSSample.addLongArray(builder, long_arrayOffset);
    FBSSample.addIntArray(builder, int_arrayOffset);
    FBSSample.addFloatValueBoxed(builder, float_value_boxed);
    FBSSample.addIntValueBoxed(builder, int_value_boxed);
    FBSSample.addFloatValue(builder, float_value);
    FBSSample.addIntValue(builder, int_value);
    FBSSample.addCharValueBoxed(builder, char_value_boxed);
    FBSSample.addShortValueBoxed(builder, short_value_boxed);
    FBSSample.addCharValue(builder, char_value);
    FBSSample.addShortValue(builder, short_value);
    FBSSample.addBooleanValueBoxed(builder, boolean_value_boxed);
    FBSSample.addBooleanValue(builder, boolean_value);
    return FBSSample.endFBSSample(builder);
  }

  public static void startFBSSample(FlatBufferBuilder builder) { builder.startTable(22); }
  public static void addIntValue(FlatBufferBuilder builder, int intValue) { builder.addInt(0, intValue, 0); }
  public static void addLongValue(FlatBufferBuilder builder, long longValue) { builder.addLong(1, longValue, 0L); }
  public static void addFloatValue(FlatBufferBuilder builder, float floatValue) { builder.addFloat(2, floatValue, 0.0f); }
  public static void addDoubleValue(FlatBufferBuilder builder, double doubleValue) { builder.addDouble(3, doubleValue, 0.0); }
  public static void addShortValue(FlatBufferBuilder builder, short shortValue) { builder.addShort(4, shortValue, 0); }
  public static void addCharValue(FlatBufferBuilder builder, short charValue) { builder.addShort(5, charValue, 0); }
  public static void addBooleanValue(FlatBufferBuilder builder, boolean booleanValue) { builder.addBoolean(6, booleanValue, false); }
  public static void addIntValueBoxed(FlatBufferBuilder builder, int intValueBoxed) { builder.addInt(7, intValueBoxed, 0); }
  public static void addLongValueBoxed(FlatBufferBuilder builder, long longValueBoxed) { builder.addLong(8, longValueBoxed, 0L); }
  public static void addFloatValueBoxed(FlatBufferBuilder builder, float floatValueBoxed) { builder.addFloat(9, floatValueBoxed, 0.0f); }
  public static void addDoubleValueBoxed(FlatBufferBuilder builder, double doubleValueBoxed) { builder.addDouble(10, doubleValueBoxed, 0.0); }
  public static void addShortValueBoxed(FlatBufferBuilder builder, short shortValueBoxed) { builder.addShort(11, shortValueBoxed, 0); }
  public static void addCharValueBoxed(FlatBufferBuilder builder, short charValueBoxed) { builder.addShort(12, charValueBoxed, 0); }
  public static void addBooleanValueBoxed(FlatBufferBuilder builder, boolean booleanValueBoxed) { builder.addBoolean(13, booleanValueBoxed, false); }
  public static void addIntArray(FlatBufferBuilder builder, int intArrayOffset) { builder.addOffset(14, intArrayOffset, 0); }
  public static int createIntArrayVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startIntArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addLongArray(FlatBufferBuilder builder, int longArrayOffset) { builder.addOffset(15, longArrayOffset, 0); }
  public static int createLongArrayVector(FlatBufferBuilder builder, long[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addLong(data[i]); return builder.endVector(); }
  public static void startLongArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addFloatArray(FlatBufferBuilder builder, int floatArrayOffset) { builder.addOffset(16, floatArrayOffset, 0); }
  public static int createFloatArrayVector(FlatBufferBuilder builder, float[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addFloat(data[i]); return builder.endVector(); }
  public static void startFloatArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addDoubleArray(FlatBufferBuilder builder, int doubleArrayOffset) { builder.addOffset(17, doubleArrayOffset, 0); }
  public static int createDoubleArrayVector(FlatBufferBuilder builder, double[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addDouble(data[i]); return builder.endVector(); }
  public static void startDoubleArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addShortArray(FlatBufferBuilder builder, int shortArrayOffset) { builder.addOffset(18, shortArrayOffset, 0); }
  public static int createShortArrayVector(FlatBufferBuilder builder, short[] data) { builder.startVector(2, data.length, 2); for (int i = data.length - 1; i >= 0; i--) builder.addShort(data[i]); return builder.endVector(); }
  public static void startShortArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(2, numElems, 2); }
  public static void addCharArray(FlatBufferBuilder builder, int charArrayOffset) { builder.addOffset(19, charArrayOffset, 0); }
  public static int createCharArrayVector(FlatBufferBuilder builder, short[] data) { builder.startVector(2, data.length, 2); for (int i = data.length - 1; i >= 0; i--) builder.addShort(data[i]); return builder.endVector(); }
  public static void startCharArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(2, numElems, 2); }
  public static void addBooleanArray(FlatBufferBuilder builder, int booleanArrayOffset) { builder.addOffset(20, booleanArrayOffset, 0); }
  public static int createBooleanArrayVector(FlatBufferBuilder builder, boolean[] data) { builder.startVector(1, data.length, 1); for (int i = data.length - 1; i >= 0; i--) builder.addBoolean(data[i]); return builder.endVector(); }
  public static void startBooleanArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static void addString(FlatBufferBuilder builder, int stringOffset) { builder.addOffset(21, stringOffset, 0); }
  public static int endFBSSample(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public FBSSample get(int j) { return get(new FBSSample(), j); }
    public FBSSample get(FBSSample obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

