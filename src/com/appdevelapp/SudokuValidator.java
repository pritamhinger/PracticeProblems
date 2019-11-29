package com.appdevelapp;

import java.util.HashSet;

public class SudokuValidator {
    public boolean IsValidSudoku(int[][] board, int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!CheckSudokuValidForPosition(board, i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean CheckSudokuValidForPosition(int[][] board, int row, int column){
        return IsRowValid(board, row) && IsColumnValid(board, column) && IsSubMatrixValid(board, row - row%3, column - column%3);
    }

    // 1. Check If the Row is Valid
    private boolean IsRowValid(int[][] board, int row){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if(set.contains(board[row][i])){
                System.out.println("Invalid at row board[" +row+"]["+ i+"]. Value is " + board[row][i]);
                return false;
            }

            if(board[row][i] != 0){
                set.add(board[row][i]);
            }
        }

        return true;
    }

    // 2. Check if the column is valid
    private boolean IsColumnValid(int[][] board, int column){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if(set.contains(board[i][column])){
                System.out.println("Invalid at row board[" +i+"]["+ column+"]. Value is " + board[i][column]);
                return false;
            }

            if(board[i][column] != 0){
                set.add(board[i][column]);
            }
        }

        return true;
    }

    // 3. Check if the SubMatrix is valid
    private boolean IsSubMatrixValid(int[][] board, int startRow, int startColumn){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(set.contains(board[i+startRow][j+startColumn])){
                    System.out.println("Invalid at row board[" + i+startRow +"]["+ j+startColumn +"]. Value is " + board[i+startRow][j+startColumn]);
                    return false;
                }

                if(board[i+startRow][j+startColumn] != 0){
                    set.add(board[i+startRow][j+startColumn]);
                }
            }
        }

        return true;
    }

}
