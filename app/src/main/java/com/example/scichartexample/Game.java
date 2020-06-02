package com.example.scichartexample;

import android.util.Log;

import java.util.Arrays;

public class Game {
    public int boardSize = 3;
    private static final String TAG = "MainTagName";

    public ElState[][][] board = new ElState[boardSize][boardSize][boardSize];
    public Game() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                Arrays.fill(board[i][j], ElState.E);
            }
        }
    }
    public void setElement(int xIndex, int yIndex, int zIndex, ElState value) {
        board[xIndex][yIndex][zIndex] = value;
    }
    public void print() {
        Log.d(TAG,"--- BOARD BEGIN ---");
        for (int i=0; i< board.length; i++) {
            for (int j = 0; j  < board.length; j++) {
                Log.d(TAG, board[i][j][0] + " " + board[i][j][1] + " " + board[i][j][2]);
                Log.d(TAG, "\n");
            }
            Log.d(TAG, "--------\n");
        }
        Log.d(TAG,"--- BOARD END ---");
    }
    public ElState checkRow2() {
        for (int i = 0; i < board.length; i++) {
            int winnerCounterCross = 0;
            int winnerCounterZero = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[0][i][j] == ElState.X || board[1][i][j] == ElState.X || board[2][i][j] == ElState.X) {
                    winnerCounterCross += 1;
                }
                if (board[0][i][j] == ElState.O || board[1][i][j] == ElState.O || board[2][i][j] == ElState.O) {
                    winnerCounterZero += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                return ElState.X;
            }
            if (winnerCounterZero == board.length) {
                return ElState.O;
            }
        }
        return ElState.E;
    }

    public ElState checkRow1() {
        for (int i = 0; i < board.length; i++) {
            int winnerCounterCross = 0;
            int winnerCounterZero = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j][0] == ElState.X || board[i][j][1] == ElState.X || board[i][j][2] == ElState.X) {
                    winnerCounterCross += 1;
                }
                if (board[i][j][0] == ElState.O || board[i][j][1] == ElState.O || board[i][j][2] == ElState.O) {
                    winnerCounterZero += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                return ElState.X;
            }
            if (winnerCounterZero == board.length) {
                return ElState.O;
            }
        }
        return ElState.E;
    }

    public ElState checkCol1() {
        for (int i = 0; i < board.length; i++) {
            int winnerCounterCross = 0;
            int winnerCounterZero = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i][0] == ElState.X || board[j][i][1] == ElState.X || board[j][i][2] == ElState.X) {
                    winnerCounterCross += 1;
                }
                if (board[j][i][0] == ElState.O || board[j][i][1] == ElState.O || board[j][i][2] == ElState.O) {
                    winnerCounterZero += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                return ElState.X;
            }
            if (winnerCounterZero == board.length) {
                return ElState.O;
            }
        }
        return ElState.E;
    }

    public ElState checkCol2() {
        for (int i = 0; i < board.length; i++) {
            int winnerCounterCross = 0;
            int winnerCounterZero = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[0][j][i] == ElState.X || board[1][j][i] == ElState.X || board[2][j][i] == ElState.X) {
                    winnerCounterCross += 1;
                }
                if (board[0][j][i] == ElState.O || board[1][j][i] == ElState.O || board[2][j][i] == ElState.O) {
                    winnerCounterZero += 1;
                }
            }
            if (winnerCounterCross == board.length) {
                return ElState.X;
            }
            if (winnerCounterZero == board.length) {
                return ElState.O;
            }
        }
        return ElState.E;
    }
}
