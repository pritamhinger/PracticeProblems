package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverse_words() {
        String result = StringProblems.reverse_words("Hello World..!!");
        System.out.println(result);
        result = StringProblems.reverse_words("The quick brown fox jumps over the lazy fox..!!");
        System.out.println(result);
    }

    @Test
    void remove_white_spaces() {
        String str = "    this is       some sentence  123..!!";
        StringProblems.remove_white_spaces(str.toCharArray());
    }

    @Test
    void can_segment_string() {
        Set<String> dict = new HashSet<>();
        dict.add("pie");
        dict.add("pear");
        dict.add("apple");
        dict.add("peach");
        dict.add("hello");
        dict.add("hell");
        dict.add("on");
        dict.add("now");
        dict.add("o");
        Assert.that(StringProblems.can_segment_string("applepie", dict), "Failed");
        Assert.that(!StringProblems.can_segment_string("applepei", dict), "Failed");
        Assert.that(StringProblems.can_segment_string("hellonowo", dict), "Failed");
    }

    @Test
    void create_xml_tree() throws Exception {
        String xml = "<html>\n" +
                "  <body>\n" +
                "    <div>\n" +
                "      <h1>CodeRust</h1>\n" +
                "      <a>http://coderust.com</a> \n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <h2>Chapter 1</h2>\n" +
                "    </div>\n" +
                "    <div>\n" +
                "        <h3>Chapter 2</h3>\n" +
                "        <h4>Chapter 2.1</h4>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "</html>";
        XMLTreeNode head = StringProblems.create_xml_tree(xml);
        head.PrintXMLNode();
        //Assert.that(head.data.equals("html"), "Failed");
    }

    @Test
    void find_all_palindrome_substrings() {
        String str = "aabbaacaabbaa";
        int result = StringProblems.find_all_palindrome_substrings(str);
        Assert.that(result == 16, "Failed");
    }

    @Test
    void find_all_palindrome_substrings_2() {
        String str = "aabbaacaabbaa";
        int result = StringProblems.find_all_palindrome_substrings_2(str);
        Assert.that(result == 16, "Failed");
    }
}