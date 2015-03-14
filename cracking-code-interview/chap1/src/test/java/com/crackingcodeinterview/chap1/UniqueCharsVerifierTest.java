package com.crackingcodeinterview.chap1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wagner on 3/14/15.
 */
public class UniqueCharsVerifierTest {

    private final String nonRepeated = "abcdefghijklmn";

    private final String repeated = "abcdefghijklmna";

    @Test
    public void assertNonRepeatedForUniqueCharsVerifier() {
        Assert.assertTrue(new UniqueCharsVerifier().verify(nonRepeated));
    }

    @Test
    public void assertRepeatedForUniqueCharsVerifier() {
        Assert.assertFalse(new UniqueCharsVerifier().verify(repeated));
    }

    @Test
    public void assertNonRepeatedForUniqueCharsVerifierWithoutSets() {
        Assert.assertTrue(new UniqueCharsVerifierWithoutSet().verify(nonRepeated));
    }



    @Test
    public void assertRepeatedForUniqueCharsVerifierWithoutSets() {
        Assert.assertFalse(new UniqueCharsVerifierWithoutSet().verify(repeated));
    }

    @Test
    public void assertNonRepeatedForAscUniqueCharsVerifier() {
        Assert.assertTrue(new AscUniqueCharsVerifier().verify(nonRepeated));
    }

    @Test
    public void assertRepeatedForAscUniqueCharsVerifier() {
        Assert.assertFalse(new AscUniqueCharsVerifier().verify(repeated));
    }

    @Test
    public void assertNonRepeatedForAscUniqueCharsVerifierWithBitmap() {
        Assert.assertTrue(new AscUniqueCharsVerifierWithBitmap().verify(nonRepeated));
    }

    @Test
    public void assertRepeatedForAscUniqueCharsVerifierWithBitmap() {
        Assert.assertFalse(new AscUniqueCharsVerifierWithBitmap().verify(repeated));
    }
}
