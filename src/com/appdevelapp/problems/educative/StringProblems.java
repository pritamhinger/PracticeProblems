package com.appdevelapp.problems.educative;

import java.util.HashSet;

public class StringProblems {
    public static String reverse_words (String sentence) {
        int len = sentence.length();
        char[] characters = new char[len+1];
        int index = 0;
        for (char ch: sentence.toCharArray()) {
            characters[index] = ch;
            index++;
        }

        characters[index] = '\0';

        String result = reverseWordHelper(characters);
        return result.substring(0, result.length()-1);
    }

    static void remove_duplicates(char[] str) {
        int back = 0;
        int forward = 0;
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            if (!characters.contains(str[i])) {
                characters.add(str[i]);
                str[back] = str[forward];
                back++;
            }

            forward++;
        }

        str[back] = '\0';
    }

    static void remove_white_spaces (char[] s) {
        int back = 0;
        int forward = 0;
        for (int i = 0; i < s.length; i++) {
            if(s[i] == '\0' || s[i] == '\t' || s[i] == ' '){
                forward++;
            }
            else{
                s[back] = s[forward];
                back++;
                forward++;
            }
        }

        s[back] = '\0';
        for (char ch: s) {
            if(ch == '\0'){
                break;
            }
            System.out.print(ch);
        }
    }

    private static String reverseWordHelper(char[] sentence){
        int length = sentence.length;
        reverseFromStartToEnd(sentence, 0, length-2);
        int start = 0;
        int end;
        while (true){
            while (sentence[start] == ' '){
                start++;
            }

            if(sentence[start] == '\0'){
                break;
            }
            end = start +1;
            while (sentence[end] != '\0' && sentence[end] != ' '){
                end++;
            }

            reverseFromStartToEnd(sentence, start, end-1);
            start = end;
        }

        return new String(sentence);
    }

    private static void reverseFromStartToEnd(char[] sentence, int start, int end){
        while (start < end){
            char ch = sentence[start];
            sentence[start] = sentence[end];
            sentence[end] = ch;
            start++;
            end--;
        }
    }
}
