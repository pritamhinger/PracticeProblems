package com.appdevelapp.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class FindCelebChallengeTest {

    int[][] party;
    @BeforeEach
    void setUp() {
        party = new int[][]{{0,1,0,1},{0,0,0,0},{1,1,0,0},{0,1,0,0}};
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findCelebrity() throws Exception {
        int candidate = FindCelebChallenge.findCelebrity(party,4);
        Assert.that(candidate == 1, "Failed");
    }
}