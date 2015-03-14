package com.crackingcodeinterview.chap1;

/**
 * An improvement for the suggested solution in the book. With some changes it could support other charsets.
 *
 * The Bitmap abstraction can help with other problems.
 *
 * Created by wagner on 3/14/15.
 */
public class AscUniqueCharsVerifierWithBitmap implements StringVerifier {
    @Override
    public boolean verify(String input) {
        int inputSize = input.length();
        if(inputSize > 128) {
            return false;
        }
        Bitmap bitmap = new Bitmap(128);
        for(int i = 0; i < inputSize; i++) {
            int index = input.charAt(i);
            if(bitmap.get(index)) {
                return false;
            }
            bitmap.set(index, true);
        }
        return true;
    }

    public static class Bitmap {
        private final long[] bitmap;
        private final long maxBit;
        private final int LONG_SIZE = Long.SIZE;

        public Bitmap(int bitSize) {
            int extrabit = (bitSize % LONG_SIZE == 0) ? 0 : 1;
            bitmap = new long[bitSize / LONG_SIZE + extrabit];
            maxBit = bitSize;
        }

        private int getLongBit(int index) {
            return index % LONG_SIZE;
        }

        private int getArrayIndex(int index) {
            return index / LONG_SIZE;
        }

        public void set(int index, boolean value) {
            if(index > maxBit) {
                throw new IllegalArgumentException();
            }
            int arrayIndex = getArrayIndex(index);
            long longValue = bitmap[arrayIndex];
            int longBitIndex = getLongBit(index);
            long mask = 1L << longBitIndex;
            if(value) {
                bitmap[arrayIndex] = longValue | mask;
            } else {
                mask = ~mask;
                bitmap[arrayIndex] = longValue & mask;
            }
        }

        public boolean get(int index) {
            if(index > maxBit) {
                throw new IllegalArgumentException();
            }
            int arrayIndex = getArrayIndex(index);
            long value = bitmap[arrayIndex];
            int longBitIndex = getLongBit(index);
            long mask = 1L << longBitIndex;
            value = value & mask;
            return (value >> longBitIndex) == 1;
        }
    }
}
