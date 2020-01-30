package com.appdevelapp.problems.leetcode;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
        int[] arr1 = {2, 4, 1};
        System.out.println(maxProfit(arr1));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int buyPrices = prices[0];
        int sellPrice = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (profit < prices[i] - buyPrices) {
                profit = prices[i] - buyPrices;
                sellPrice = prices[i];
            }

            if (buyPrices > prices[i]) {
                buyPrices = prices[i];
            }
        }

        return profit;
//        int minNumber = Integer.MAX_VALUE;
//        int minIndex = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minNumber) {
//                minNumber = prices[i];
//                minIndex = i;
//            }
//        }
//
//        int diff = 0;
//        for (int i = minIndex + 1; i < prices.length; i++) {
//            if (diff < prices[i] - minNumber) {
//                diff = prices[i] - minNumber;
//            }
//        }
//
//        return diff;
    }
}