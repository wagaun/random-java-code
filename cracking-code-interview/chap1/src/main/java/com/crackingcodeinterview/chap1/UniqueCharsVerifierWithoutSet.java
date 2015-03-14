package com.crackingcodeinterview.chap1;

/**
 * An implementation without the set. The complexity is O(n^2) and the memory consumption is O(1).
 *
 * Created by wagner on 3/14/15.
 */
public class UniqueCharsVerifierWithoutSet implements StringVerifier {
    @Override
    public boolean verify(String input) {
        int inputSize = input.length();
        for(int i = 0; i < inputSize; i++) {
            char current = input.charAt(i);
            for(int j = 0; j < i; j++) {
                char previous = input.charAt(j);
                if(previous == current) {
                    return false;
                }
            }
        }
        return true;
    }
}
