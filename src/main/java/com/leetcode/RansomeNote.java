package com.leetcode;

/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

        Each letter in the magazine string can only be used once in your ransom note.

        Note:
        You may assume that both strings contain only lowercase letters.

        canConstruct("a", "b") -> false
        canConstruct("aa", "ab") -> false
        canConstruct("aa", "aab") -> true*/

public class RansomeNote {

    public static boolean ransomeNotes(String ransomNote, String magazine){
        char[] from = magazine.toCharArray();
        char[] to = ransomNote.toCharArray();

        int[] alpabeth = new int[26];

        for(char c : from){

            alpabeth[((int) c) - 97] = alpabeth[((int) c) - 97]+1;

        }

        for(char c : to){
            if (alpabeth[((int) c) - 97] < 1){
                return false;
            }else{
                alpabeth[((int) c) - 97] = alpabeth[((int) c) - 97] - 1;
            }
        }

        return true;
    }

    public static void main(String[] args){
        boolean result = ransomeNotes("aa","aab");
        System.out.println(result);
    }

}
