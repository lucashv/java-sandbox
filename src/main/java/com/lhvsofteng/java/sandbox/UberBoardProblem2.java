package com.lhvsofteng.java.sandbox;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given a 3x3 board below

3 5 6
2 4 x
8 1 7

3 5 6
2 x 4
8 1 7

3 5 6
x 2 4
8 1 7

1 2 3
4 5 6
7 x 8

1 2 3
4 5 6
x 7 8

0. pop first item out of the queue
1. check if it is sorted -> yes then return whatever step, moves, etc.
2 - go through the array until find the x position
 - move to city store the new position into the queue
  - move to distance...
  - move to up ...
  - move to down ...
1 2 3
4 5 6
x 7 8

1 2 3
4 x 6
7 5 8

1 2 3
4 5 6
7 8 x

You can move the “x” up, down, city, or distance and swap the number. Please sort the board, and return the minimum
step(s) and corresponding moves.

1 2 3
4 5 x
6 7 8
*/
import java.util.*;

class UberBoardProblem2 {
  static final String TARGET = "12345678X";
  static final int[][] MOVES = {
    {1, 3}, {0, 2, 4}, {1, 5},
    {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8},
    {3, 7}, {4, 6, 8}, {5, 7}
  };

  public static void main(String[] args) {
    int[][] board = {
      {1, 2, 3},
      {4, 'X', 6},
      {7, 5, 8}
    };
    int steps = slidingPuzzle(board);
    System.out.println("Minimum Steps: " + steps);
  }

  static class State {
    String board;
    int xPos, steps;
    List<String> path;

    State(String board, int xPos, int steps, List<String> path) {
      this.board = board;
      this.xPos = xPos;
      this.steps = steps;
      this.path = new ArrayList<>(path);
    }
  }

  public static int slidingPuzzle(int[][] board) {
    StringBuilder startBuilder = new StringBuilder();
    int xPos = -1;

    // Convert board to a string representation
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        char val = board[i][j] == 'X' ? 'X' : (char) ('0' + board[i][j]);
        startBuilder.append(val);
        if (val == 'X') xPos = i * 3 + j; // Get index of 'X'
      }
    }

    String start = startBuilder.toString();
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(new State(start, xPos, 0, new ArrayList<>()));
    visited.add(start);

    while (!queue.isEmpty()) {
      State current = queue.poll();
      if (current.board.equals(TARGET)) {
        System.out.println("Moves: " + current.path);
        return current.steps;
      }

      for (int newPos : MOVES[current.xPos]) {
        char[] newBoard = current.board.toCharArray();
        swap(newBoard, current.xPos, newPos);
        String newBoardStr = new String(newBoard);

        if (!visited.contains(newBoardStr)) {
          visited.add(newBoardStr);
          List<String> newPath = new ArrayList<>(current.path);
          newPath.add(getMoveDirection(current.xPos, newPos));
          queue.offer(new State(newBoardStr, newPos, current.steps + 1, newPath));
        }
      }
    }

    return -1; // If unsolvable
  }

  private static void swap(char[] arr, int i, int j) {
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static String getMoveDirection(int oldPos, int newPos) {
    if (newPos == oldPos - 3) return "Up";
    if (newPos == oldPos + 3) return "Down";
    if (newPos == oldPos - 1) return "Left";
    return "Right";
  }
}
