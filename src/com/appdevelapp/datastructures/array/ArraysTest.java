package com.appdevelapp.datastructures.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

class ArraysTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void arrayInitializationExample() {
        Assert.that(Arrays.OneDimensionalArrayInitializationExample(), "Exception occured");
    }

    @Test
    void twoDimensionalArrayInitializationExample() {
        Assert.that(Arrays.TwoDimensionalArrayInitializationExample(), "Exception in initialization");
    }

    @Test
    void removeEven() {
        int arr[] = {1,2,4,5,10,6,3};
        Assert.that(Arrays.removeEven(arr).length == 3, "Failed");
    }

    @Test
    void findSum() {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 8};
        int result[] = Arrays.findSum(arr, 27);
        Assert.that((result[0] == 21 || result[0] == 6)&& (result[1] == 6 || result[1] == 21),"Failed");
    }

    @Test
    void findProduct() {
        int[] arr = {1,2,3,4};
        int[] res = Arrays.findProduct(arr);
        for (int item: res) {
            System.out.print(item + "  ");
        }

        System.out.println();
        int[] arr1 = {1,2,3,4,0};
        res = Arrays.findProduct(arr1);
        for (int item: res) {
            System.out.print(item + "  ");
        }
        System.out.println();
        Assert.that(arr1.length == res.length, "Failed");
    }

    @Test
    void testFindProduct() {
    }

    @Test
    void findFirstUnique() {
        int[] arr = {4,5,1,2,0,4};
        int res = Arrays.findFirstUnique(arr);
        System.out.println(res);
        Assert.that(res == 5, "Failed");
    }

    @Test
    void findSecondMaximum() {
        int arr[] = {4,2,1,5,0};
        int res = Arrays.findSecondMaximum(arr);
        Assert.that(res == 4, "Failed");
    }

    @Test
    void rotateArray() {
        int[] arr = {1,2,3,4,5};
        Arrays.rotateArray(arr);
    }

    @Test
    void reArrange() {
        int[] arr = {2, 4, -6, 8, -5, -10,1};
        Arrays.reArrange(arr);
        Assert.that(arr.length == 7, "Failed");
    }

    @Test
    void maxMin() {
        int[] arr = {1, 2, 3, 4, 5,6};
        Arrays.maxMin(arr);
        Assert.that(arr.length == 6, "Failed");
    }
}