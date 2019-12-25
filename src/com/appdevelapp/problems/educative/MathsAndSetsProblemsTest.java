package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathsAndSetsProblemsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

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

    @Test
    void integer_divide() {
        int quotient = MathsAndSetsProblems.integer_divide(55,11);
        Assert.that(quotient == 5, "FailedÐ");
    }

    @Test
    void find_pythagorean_triplets() {
        int[] arr = {4,16,1,2,3,5,6,8,25,10};
        List<int[]> output =  MathsAndSetsProblems.find_pythagorean_triplets(arr);
        for (int i = 0; i < output.size(); i++) {
            System.out.println(Arrays.toString(output.get(i)));
        }
        Assert.that(output.size() == 2, "Failed");
    }

    @Test
    void permuteString() {
        List<String> output = MathsAndSetsProblems.permuteString("pritam");
        for (String str: output
             ) {
            System.out.println(str);
        }
    }

    @Test
    void power() {
        Assert.that(MathsAndSetsProblems.power(2.0, 2) == 4.0, "Failed");
        Assert.that(MathsAndSetsProblems.power(2.0, -2) == 0.25, "Failed");
    }

    @Test
    void squareRoot() {
        Assert.that(MathsAndSetsProblems.squareRoot(9) == 3.0, "Failed");
    }
}