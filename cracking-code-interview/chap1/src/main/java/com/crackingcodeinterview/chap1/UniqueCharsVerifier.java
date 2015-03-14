package com.crackingcodeinterview.chap1;

import java.util.HashSet;
import java.util.Set;

/**
 * Fist implementation for the problem. The most naive.
 *
 * The complexity is O(n) where n is the size of the input string since the search on a hashset is O(1) in time.
 *
 * But the memory consumption is O(n), because of the HashSet.
 *
 * Created by wagner on 3/14/15.
 */
public class UniqueCharsVerifier implements StringVerifier {

    @Override
    public boolean verify(String input) {
        int inputSize = input.length();
        Set<Character> usedChars = new HashSet<Character>(inputSize);
        for(int i = 0; i < inputSize; i++) {
            char current = input.charAt(i);
            if(usedChars.contains(current)) {
                return false;
            }
            usedChars.add(current);
        }
        return true;
    }
}
