package com.appdevelapp.problems;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PathTracerTest {

    HashMap<String, String> map;
    @BeforeEach
    void setUp() {
        map = new HashMap<String, String>();
        map.put("NewYork", "Chicago");
        map.put("Boston", "Texas");
        map.put("Missouri", "NewYork");
        map.put("Texas", "Missouri");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void tracePath() {
        String result = PathTracer.tracePath(map);
        System.out.println(result);
        Assert.that(result.equals("Boston->Texas, Texas->Missouri, Missouri->NewYork, NewYork->Chicago, "), "Failed");
    }
}