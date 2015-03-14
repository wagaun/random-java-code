package com.crackingcodeinterview.chap1;

/**
 * This is the 'suggested' solution for the problem. It assumes that the string has only ascii chars.
 *
 * Created by wagner on 3/14/15.
 */
public class AscUniqueCharsVerifier implements StringVerifier {
    @Override
    public boolean verify(String input) {
        int inputSize = input.length();
        if(inputSize > 128) {
            return false;
        }
        boolean[] charOccured = new boolean[128];
        for(int i = 0; i < inputSize; i++) {
            char current = input.charAt(i);
            int currentIndex = (int) current;
            if(charOccured[currentIndex]) {
                return false;
            }
            charOccured[currentIndex] = true;
        }
        return true;
    }
}
