package com.appdevelapp.problems.educative;

import java.util.List;

public class MathsAndSetsProblems {

    static void find_kth_permutation(List<Character> v, int k, StringBuilder result) {
        if (v.isEmpty()) {
            return;
        }

        int n = v.size();
        int[] factorials = getFactorialSeries(n);
        int sizeOfBlock = factorials[n-1];
        int selectedNumber = (k-1)/sizeOfBlock;
        Character ch = v.get(selectedNumber);
        result.append(ch);
        v.remove(selectedNumber);
        int newK = k - (sizeOfBlock * selectedNumber);
        find_kth_permutation(v, newK, result);
    }

    private static int[] getFactorialSeries(int n) {
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        factorials[1] = 1;
        for (int i = 2; i <= n ; i++) {
            factorials[i] = i * factorials[i-1];
        }

        return factorials;
    }
}
