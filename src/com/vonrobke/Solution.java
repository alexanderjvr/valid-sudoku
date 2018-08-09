package com.vonrobke;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> current = new HashSet<>();

        // Check horizontal
        for (int i = 0; i < 9; i++) {
            current.clear();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (current.contains(board[i][j])) {
                        return false;
                    }
                    current.add(board[i][j]);
                }
            }
        }
        // Check vertical
        for (int j = 0; j < 9; j++) {
            current.clear();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (current.contains(board[i][j])) {
                        return false;
                    }
                    current.add(board[i][j]);
                }
            }
        }

        // Check sections
        for (int i = 0; i < 9; i += 3) {
            current.clear();
            for (int j = 0; j < 9; j += 3) {
                current.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i+k][j+l] != '.'){
                            if (current.contains(board[i+k][j+l])) {
                                return false;
                            }
                            current.add(board[i+k][j+l]);
                        }
                    }
                }
            }
        }

        return true;
    }
}