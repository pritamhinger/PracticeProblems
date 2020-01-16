package com.appdevelapp.problems.educative.dynamicprogramming;

public class EqualSumSet {
    public static void main(String[] args) {
        EqualSumSet set = new EqualSumSet();
        System.out.println("Brute Force Solutions");
        int[] num = {1, 2, 3, 4};
        System.out.println(set.checkIfEqualSetPartitionable_BruteForce(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(set.checkIfEqualSetPartitionable_BruteForce(num));
        num = new int[]{1, 2, 3, 8};
        System.out.println(set.checkIfEqualSetPartitionable_BruteForce(num));

        System.out.println("Top Down Approach Solutions");
        num = new int[]{1, 2, 3, 4};
        System.out.println(set.checkIfEqualSetPartitionable_TopDownApproach(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(set.checkIfEqualSetPartitionable_TopDownApproach(num));
        num = new int[]{1, 2, 3, 8};
        System.out.println(set.checkIfEqualSetPartitionable_TopDownApproach(num));
    }

    public boolean checkIfEqualSetPartitionable_BruteForce(int[] numbers) {

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return checkIfEqualSetPartitionableHelper_BruteForce(numbers, sum / 2, 0);
    }

    private boolean checkIfEqualSetPartitionableHelper_BruteForce(int[] numbers, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }

        if (numbers.length == 0 || currentIndex >= numbers.length) {
            return false;
        }

        if (numbers[currentIndex] <= sum) {
            if (checkIfEqualSetPartitionableHelper_BruteForce(numbers, sum - numbers[currentIndex], currentIndex + 1)) {
                return true;
            }
        }

        return checkIfEqualSetPartitionableHelper_BruteForce(numbers, sum, currentIndex + 1);
    }

    private boolean checkIfEqualSetPartitionable_TopDownApproach(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[numbers.length][sum / 2 + 1];
        return checkIfEqualSetPartitionableHelper_TopDownApproach(dp, numbers, sum / 2, 0);
    }

    private boolean checkIfEqualSetPartitionableHelper_TopDownApproach(Boolean[][] dp, int[] numbers, int sum, int currentIndex) {
        if (sum == 0) {
            return true;
        }

        if (numbers.length == 0 || currentIndex >= numbers.length) {
            return false;
        }

        if (dp[currentIndex][sum] == null) {
            if (numbers[currentIndex] <= sum) {
                if (checkIfEqualSetPartitionableHelper_TopDownApproach(dp, numbers, sum - numbers[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            dp[currentIndex][sum] = checkIfEqualSetPartitionableHelper_TopDownApproach(dp, numbers, sum, currentIndex + 1);
        }

        return dp[currentIndex][sum];
    }

    public boolean checkIfEqualSetPartitionable_BottomUpApproach(int[] num) {

        return false;
    }
}
