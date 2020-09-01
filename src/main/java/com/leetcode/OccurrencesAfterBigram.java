package com.leetcode;

/**
 * Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 *
 * For each such occurrence, add "third" to the answer, and return the answer.
 *
 *
 *
 * Example 1:
 *
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 *
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 *
 *
 * Note:
 *
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 */
public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] result = text.split(" ");
        String res = "";

        for (int i = 0; i < result.length - 1; i++) {

            if (result[i].equals(first) && result[i+1].equals(second)) {
                if ((i + 2) <= result.length - 1) {
                    res +=  result[i+2] + " ";
                }
            }

        }

        if (res.equals("")) return new String[0];
        return res.split(" ");
    }


    public static void main(String[] args) {
        OccurrencesAfterBigram o = new OccurrencesAfterBigram();
        String[] g = o.findOcurrences("alice is a good girl she is a goo student","a","jeje");
        String g1 = g[0];
        String[] h = new String[2];
        int jintf = 0;
    }
}
