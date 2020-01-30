package com.appdevelapp.problems.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid1));

        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(orangesRotting(grid2));

        int[][] grid3 = {{0}};
        System.out.println(orangesRotting(grid3));

        int[][] grid4 = {{2, 2, 2, 1, 1}};
        System.out.println(orangesRotting(grid4));

        int[][] grid5 = {{2, 0, 1, 2, 1, 2}};
        System.out.println(orangesRotting(grid5));

        int[][] grid6 = {{1, 2, 1, 1, 2, 1, 1}};
        System.out.println(orangesRotting(grid6));
    }

    public static int orangesRotting(int[][] grid) {
        if (!checkIfAnyFreshLeft(grid)) {
            return 0;
        }

        LinkedList<OrangeCoordinates> queue = new LinkedList<>();
        List<OrangeCoordinates> startingOrange = getFirstRottenOrange(grid);
        if (startingOrange == null) {
            return -1;
        }

        for (OrangeCoordinates coord : startingOrange) {
            queue.add(coord);
        }

        int MAX_ROW = grid.length;
        int MAX_COL = grid[0].length;

        int opCount = 0;
        int levelSoFar = 0;
        while (!queue.isEmpty()) {
            boolean gotOne = false;
            OrangeCoordinates currentOrange = queue.poll();
            int curLevel = currentOrange.level;
            int currentRow = currentOrange.rowIndex;
            int currentCol = currentOrange.colIndex;
            grid[currentRow][currentCol] = -1;
            // Check Above Orange
            if (currentRow - 1 >= 0) {
                if (grid[currentRow - 1][currentCol] == 1) {
                    grid[currentRow - 1][currentCol] = -1;
                    gotOne = true;
                    queue.add(new OrangeCoordinates(currentRow - 1, currentCol, curLevel + 1));
                }
//                else if(grid[currentRow-1][currentCol] == 2){
//                    queue.add(new OrangeCoordinates(currentRow - 1, currentCol));
//                }
            }
            // Check Left Orange
            if (currentCol - 1 >= 0) {
                if (grid[currentRow][currentCol - 1] == 1) {
                    gotOne = true;
                    grid[currentRow][currentCol - 1] = -1;
                    queue.add(new OrangeCoordinates(currentRow, currentCol - 1, curLevel + 1));
                }
//                else if(grid[currentRow][currentCol-1] == 2){
//                    queue.add(new OrangeCoordinates(currentRow, currentCol - 1));
//                }
            }
            // Check Right Orange
            if (currentCol + 1 < MAX_COL) {
                if (grid[currentRow][currentCol + 1] == 1) {
                    gotOne = true;
                    grid[currentRow][currentCol + 1] = -1;
                    queue.add(new OrangeCoordinates(currentRow, currentCol + 1, curLevel + 1));
                }
//                else if(grid[currentRow][currentCol+1] == 2){
//                    queue.add(new OrangeCoordinates(currentRow, currentCol + 1));
//                }
            }

            // Check Bottom Orange
            if (currentRow + 1 < MAX_ROW) {
                if (grid[currentRow + 1][currentCol] == 1) {
                    gotOne = true;
                    grid[currentRow + 1][currentCol] = -1;
                    queue.add(new OrangeCoordinates(currentRow + 1, currentCol, curLevel + 1));
                }
//                else if(grid[currentRow+1][currentCol] == 2){
//                    queue.add(new OrangeCoordinates(currentRow + 1, currentCol));
//                }
            }

            if (gotOne && curLevel > levelSoFar) {
                opCount++;
                levelSoFar = curLevel;
            }
        }

        if (checkIfAnyFreshLeft(grid)) {
            return -1;
        }

        return opCount;
    }

    static boolean checkIfAnyFreshLeft(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<OrangeCoordinates> getFirstRottenOrange(int[][] grid) {
        ArrayList<OrangeCoordinates> list = new ArrayList<>();

        int row = grid.length;
        int col = 0;
        if (row > 0) {
            col = grid[0].length;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    list.add(new OrangeCoordinates(i, j, 1));
                }
            }
        }

        if (list.size() == 0) {
            return null;
        }

        return list;
    }
}

class OrangeCoordinates {
    int rowIndex;
    int colIndex;
    int level;

    public OrangeCoordinates(int row, int col, int level) {
        this.rowIndex = row;
        this.colIndex = col;
        this.level = level;
    }
}
