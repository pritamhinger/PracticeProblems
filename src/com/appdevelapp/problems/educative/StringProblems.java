package com.appdevelapp.problems.educative;

import com.appdevelapp.datastructures.queue.Queue;
import com.appdevelapp.datastructures.stack.Stack;

import java.util.*;

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

    public static boolean can_segment_string(String s, Set<String> dict) {

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if(dict.contains(left)){
                String right = s.substring(i);
                if(right == null || right == "" || dict.contains(right) || can_segment_string(right, dict)){
                    return true;
                }
            }
        }

        return false;
    }

    public static XMLTreeNode create_xml_tree(String xml) throws Exception {
        XMLTreeNode head = null;
        XMLTreeNode curNode = null;
        Stack<XMLTreeNode> tags = new Stack<>(10);
        char[] characters = xml.toCharArray();
        boolean readingTag = false;
        String xmlTag = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];
            if(ch == '\n' || ch=='\t' || ch == ' ') continue;

            if(ch == '<'){
                if(builder.length() > 0){
                    XMLTreeNode node = new XMLTreeNode(builder.toString());
                    tags.top().children.add(node);
                }
                readingTag = true;
                builder = new StringBuilder();
                continue;
            }

            if(ch == '>'){
                String tag = builder.toString();
                XMLTreeNode node = GetNode(tag);
                if(head == null){
                    head = node;
                    curNode = node;
                }
                else{
                    tags.top().children.add(node);
                }

                tags.push(node);
                readingTag = false;
                builder = new StringBuilder();
                continue;
            }

            if(ch == '/'){
                if(readingTag) {
                    String matchingTag = tags.top().data;
                    i = i + matchingTag.length() + 1;
                    tags.pop();
                    continue;
                }

                // Closing Tag
            }

            if(readingTag){
                builder.append(ch);
                continue;
            }
            else{
                builder.append(ch);
            }
        }

        return head;
    }

    // This approach have a cubic run time O(n^3) which is bad.
    public static int find_all_palindrome_substrings(String input) {
        int count = 0;
        int size = 2;
        while (size <= input.length()) {
            for (int i = 0; i <= input.length()-size; i++) {
                String substring = input.substring(i, i+size);
                if(checkIfPalindrome(substring)){
                    count++;
                }
            }

            size++;
        }
        return count;
    }

    private static boolean checkIfPalindrome(String str){
        int left = 0;
        int right = str.length() -1;
        while (left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int find_all_palindrome_substrings_2(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count += find_all_palindrome_substrings_2(input, i-1, i+1);
            count += find_all_palindrome_substrings_2(input, i, i+1);
        }

        return count;
    }

    private static int find_all_palindrome_substrings_2(String input, int left, int right)
    {
        int count = 0;
        for (; left >= 0 && right < input.length() ; left--, right++) {
            if(input.charAt(left) != input.charAt(right)){
                break;
            }

            count++;
        }
        return count;
    }
    private static XMLTreeNode GetNode(String data){
        return new XMLTreeNode(data);
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

class XMLTreeNode{
    String data;
    List<XMLTreeNode> children;

    public XMLTreeNode(String data){
        this.data = data;
        children = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<XMLTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<XMLTreeNode> children) {
        this.children = children;
    }

    public void PrintXMLNode() throws Exception {
        Queue<XMLTreeNode> queue = new Queue<>(10);
        queue.enqueue(this);
        while (!queue.isEmpty()){
            XMLTreeNode curNode = queue.dequeue();
            for (XMLTreeNode child: curNode.children) {
                queue.enqueue(child);
            }

            System.out.println(curNode.data + " --> ");
        }
    }
}
