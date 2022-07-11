package com.leetcode;


import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.assertj.core.api.Assertions.assertThat;

public class IsSubsecuence {
    //substring subsecuence of string
    public boolean isSubsequence(String substring, String string) {
        int indexOfSubstring = 0;
        for (int indexOfString= 0; indexOfSubstring < substring.length() && indexOfString < string.length(); indexOfString++) {
            int sInt = string.charAt(indexOfString);
            int subInt = substring.charAt(indexOfSubstring);
            if (subInt == sInt) {
                indexOfSubstring++;
            }
        }
        return substring.length() == indexOfSubstring;
    }

    @Test
    public void testIsSubsecuence() {
        IsSubsecuence isSubsecuence = new IsSubsecuence();
        assertThat(isSubsequence("abcdef", "abcdefgha")).isTrue();
        assertThat(isSubsequence("ab", "abba")).isTrue();
        assertThat(isSubsequence("abc", "abd")).isFalse();
        assertThat(isSubsequence("aaa", "aaa")).isTrue();
        assertThat(isSubsequence("lko", "llkoha")).isTrue();
        assertThat(isSubsequence("abcde", "abcdc")).isFalse();
    }
}
