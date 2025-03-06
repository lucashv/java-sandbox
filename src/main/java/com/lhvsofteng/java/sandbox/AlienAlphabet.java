package com.lhvsofteng.java.sandbox;

import java.util.HashMap;
import java.util.Map;

public class AlienAlphabet {
    // For a give alien alphabet
    // ["hello", "uber"], "abcdefghejklmnopqrstuwxyz"
    public static void main(String[] args) {
        System.out.println("Hello");
        String[] words = new String[] {  "hello", "word", "world", "zebra" }; // { "hello", "uber" };

        String alphabet = "abcdefghejklmnopqrstuwxyz"; // "qrstuwxyzabcdefghejklmnop"; // "abcdefghejklmnopqrstuwxyz";
        System.out.println(isSorted(words, alphabet));
    }

    public static boolean isSorted(String[] words, String alphabet) {
        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++)
            dict.put(alphabet.charAt(i), i);

        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];

            for (int j = 0; j < firstWord.length(); j++) {
                int idxFirstWord = dict.get(firstWord.charAt(j));
                int idxSecondWord = dict.get(secondWord.charAt(j));

                if (idxFirstWord == idxSecondWord)
                    continue;

                if (idxFirstWord < idxSecondWord)
                    break;
                else
                    return false;
            }

        }

        return true;
    }
}
