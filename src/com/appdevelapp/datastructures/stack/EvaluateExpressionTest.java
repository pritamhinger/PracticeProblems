package com.appdevelapp.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateExpressionTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void evaluatePostFix() throws Exception {
        Integer result = EvaluateExpression.evaluatePostFix("638*+4-");
        Assert.that(result == 26, "Failed");
    }
}