package com.appdevelapp.challenges.gfg;

public class RecursiveProblems {
    public static long factorial_recursive(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        return n * factorial_recursive(n-1);
    }

    public static long fibbonachi(int n){
        long[] fibs = new long[n + 1];
        for (int i = 0; i <= n ; i++) {
            fibs[i] = 0;
        }

        return fibboanchi_recurive(n, fibs);

    }

    private static long fibboanchi_recurive(int n, long[] fibs){
        if(n == 0 || n == 1){
            return 1;
        }

        if(fibs[n] != 0){
            System.out.println("Cache Hit");
            return fibs[n];
        }

        fibs[n] = fibboanchi_recurive(n-1, fibs) + fibboanchi_recurive(n-2, fibs);
        return fibs[n];
    }
}
