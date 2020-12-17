package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl;
        rsl = winVertical(board) || winHorizontal(board);
        return rsl;
    }

    public static boolean winVertical(int[][] board) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean winHorizontal(int[][] board) {
        boolean result = false;
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == 1) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
