package org.tensorflow.lite.examples.detection;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimilarityUtils {

    public static byte[] floatArrayToByteArray(float[][] floats) {
        ByteBuffer buffer =
                ByteBuffer.allocate(4 * floats[0].length)
                        .order(ByteOrder.nativeOrder());

        for (float f : floats[0]) {
            buffer.putFloat(f);
        }
        return buffer.array();
    }

    public static float[][] byteArrayToFloatArray(byte[] bytes) {
        ByteBuffer buffer =
                ByteBuffer.wrap(bytes)
                        .order(ByteOrder.nativeOrder());

        float[][] result = new float[1][bytes.length / 4];
        for (int i = 0; i < result[0].length; i++) {
            result[0][i] = buffer.getFloat();
        }
        return result;
    }
}
