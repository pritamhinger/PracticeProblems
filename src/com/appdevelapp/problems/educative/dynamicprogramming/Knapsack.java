package com.appdevelapp.problems.educative.dynamicprogramming;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16, 12};
        int[] weights = {1, 2, 3, 5, 2};
        int maxProfit = ks.solveKnapsackBruteForce(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackBruteForce(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        maxProfit = ks.solveKnapsackUsingMemoization(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackUsingMemoization(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        maxProfit = ks.solveKanpsackBottomUpApproach(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKanpsackBottomUpApproach(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    public int solveKnapsackBruteForce(int[] profits, int[] weigths, int capacity) {
        return solveKnapsackBruteForceHelper(profits, weigths, capacity, 0);
    }

    private int solveKnapsackBruteForceHelper(int[] profits, int[] weights, int capcity, int currentIndex) {
        if (capcity <= 0 || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capcity) {
            profit1 = profits[currentIndex] + solveKnapsackBruteForceHelper(profits, weights, capcity - weights[currentIndex], currentIndex + 1);
        }

        int profit2 = solveKnapsackBruteForceHelper(profits, weights, capcity, currentIndex + 1);
        return Math.max(profit1, profit2);
    }

    public int solveKnapsackUsingMemoization(int[] profits, int[] weights, int capacity) {
        Integer[][] distributionMatrix = new Integer[profits.length][capacity + 1];
        return solveKnapsackUsingMemoizationHelper(profits, weights, capacity, distributionMatrix, 0);
    }

    private int solveKnapsackUsingMemoizationHelper(int[] profits, int[] weights, int capacity, Integer[][] distributionMatrix, int currentIndex) {

        if (currentIndex >= profits.length || capacity <= 0) {
            return 0;
        }

        if (distributionMatrix[currentIndex][capacity] != null) {
            System.out.println("Cache Hit");
            return distributionMatrix[currentIndex][capacity];
        }

        int profit1 = 0;
        if (weights[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + solveKnapsackUsingMemoizationHelper(profits, weights, capacity - weights[currentIndex], distributionMatrix, currentIndex + 1);
        }

        int profit2 = solveKnapsackUsingMemoizationHelper(profits, weights, capacity, distributionMatrix, currentIndex + 1);

        distributionMatrix[currentIndex][capacity] = Math.max(profit1, profit2);
        return distributionMatrix[currentIndex][capacity];
    }

    public int solveKanpsackBottomUpApproach(int[] profits, int[] weights, int capacity) {
        if (profits.length <= 0 || capacity <= 0 || weights.length != profits.length) {
            return 0;
        }

        int[][] distributionMatrix = new int[profits.length][capacity + 1];
        for (int i = 0; i < profits.length; i++) {
            distributionMatrix[i][0] = 0;
        }

        for (int index = 0; index <= capacity; index++) {
            if (weights[0] < index) {
                distributionMatrix[0][index] = profits[0];
            }
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;
                if (weights[i] <= c) {
                    profit1 = profits[i] + distributionMatrix[i - 1][c - weights[i]];
                }

                profit2 = distributionMatrix[i - 1][c];
                distributionMatrix[i][c] = Math.max(profit1, profit2);
            }
        }

        return distributionMatrix[profits.length - 1][capacity];
    }
}
