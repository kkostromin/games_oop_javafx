package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int index = 0; index < board.length; index++) {
            if (checkDiagonal(board, index) && winVertical(board, index) || winHorizontal(board, index)){
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean winVertical(int[][] board, int row) {
        boolean result = true;
        for (int cell = 0; cell < board.length; cell++) {
            if (board[row][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean winHorizontal(int[][] board, int cell) {
        boolean result = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkDiagonal(int[][] board, int number) {
        boolean result = false;
        if (board[number][number] == 1) {
            result = true;
        }
        return result;
    }
}
