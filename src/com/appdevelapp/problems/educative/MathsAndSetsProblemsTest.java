package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathsAndSetsProblemsTest {

    @Test
    void find_kth_permutation() {
        List<Character> v = new ArrayList<Character>();
        char ch = '1';
        for (int i = 0; i < 4; i++) {
            v.add(ch);
            ch++;
        }

        StringBuilder builder = new StringBuilder();
        MathsAndSetsProblems.find_kth_permutation(v, 8, builder);
        Assert.that(builder.toString().equals("2143"), "Failed");

        builder = new StringBuilder();
        v = new ArrayList<Character>();
        ch = '1';
        for (int i = 0; i < 4; i++) {
            v.add(ch);
            ch++;
        }
        MathsAndSetsProblems.find_kth_permutation(v, 17, builder);
        Assert.that(builder.toString().equals("3412"), "Failed");
    }
}