package com.appdevelapp.problems.educative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    ArrayList<Tuple<Integer, Integer>> list;
    @BeforeEach
    void setUp() {
        list = new ArrayList<Tuple<Integer, Integer>>();
        list.add(new Tuple<>(2,10));
        list.add(new Tuple<>(4,12));
        list.add(new Tuple<>(13,16));
        list.add(new Tuple<>(19,20));
        list.add(new Tuple<>(20,24));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void merge_intervals() {
        ArrayList<Tuple<Integer, Integer>> result = MergeIntervals.merge_intervals(list);
        for (Tuple<Integer, Integer> interval: result) {
            System.out.println("[" + interval.x + "," + interval.y + "]");
        }

    }
}