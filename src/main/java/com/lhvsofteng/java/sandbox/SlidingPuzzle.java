package com.lhvsofteng.java.sandbox;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// You can move the “x” up, down, left, or right and swap the number. Please sort the board, and
// return the minimum
// step(s) and corresponding moves.
// Example:
// Initial state:
// 1 2 3
// 4 x 6
// 7 5 8
// 1234x6758
// Final State:
// 1 2 3
// 4 5 6
// 7 8 x
// 12345678x
public class SlidingPuzzle {

  private static final String TARGET = "12345678x";
  private static final int[][] ALLOWED_MOVES =
      new int[][] {
        {1, 3}, {0, 4, 2}, {1, 5},
        {0, 4, 6}, {1, 3, 5, 7}, {2, 4, 8},
        {3, 7}, {6, 4, 8}, {5, 7}
      };
  private static final String X = "x";

  public static void main(String[] args) {
    //    var board =
    //        new String[][] {
    //          {"1", "2", "3"},
    //          {"4", "x", "6"},
    //          {"7", "5", "8"}
    //        };
    var board =
        new String[][] {
          {"4", "8", "6"},
          {"3", "5", "2"},
          {"1", "x", "7"}
        };
    var boardState = slidingPuzzle(board);

    if (boardState != null) {
      out.println("=======| Final Board State |==============");
      out.println("Board: ");
      printBoard(boardState.board);
      out.println("Steps: " + boardState.qtyMoves);
      out.println("Moves: " + boardState.moveNames);
    } else {
      out.println("Not possible to sort");
    }
  }

  private static BoardState slidingPuzzle(String[][] board) {
    var flattenSb = new StringBuilder();
    for (var i = 0; i < 3; i++) for (var j = 0; j < 3; j++) flattenSb.append(board[i][j]);

    var flattenBoard = flattenSb.toString();

    if (TARGET.equals(flattenBoard)) {
      return new BoardState(flattenBoard, 0, 0, List.of());
    }

    var xPos = flattenBoard.indexOf(X);
    var que = new LinkedList<BoardState>();
    var seen = new HashSet<String>();

    que.add(new BoardState(flattenBoard, xPos, 0, new ArrayList<>()));
    seen.add(flattenBoard);

    while (!que.isEmpty()) {
      var boardState = que.poll();

      printBoard(boardState.board);
      // out.println("boardState = " + boardState.board);
      // out.println("xPos = " + boardState.xPos);
      // out.println("Steps = " + steps);

      if (TARGET.equals(boardState.board)) {
        return boardState;
      }

      var moves = ALLOWED_MOVES[boardState.xPos];
      for (var newPos : moves) {
        var newBoardStr = swap(boardState.board, boardState.xPos, newPos);
        if (!seen.contains(newBoardStr)) {
          seen.add(newBoardStr);
          var newMoves = new ArrayList<>(boardState.moveNames);
          newMoves.add(getMove(boardState.xPos, newPos));
          que.add(new BoardState(newBoardStr, newPos, boardState.qtyMoves + 1, newMoves));
        }
      }
      out.println();
      out.println("===============================================================");
    }

    return null;
  }

  private static String swap(String board, int curXPos, int newXPos) {
    char[] boardArr = board.toCharArray();
    var temp = boardArr[newXPos];
    boardArr[newXPos] = X.charAt(0);
    boardArr[curXPos] = temp;
    return new String(boardArr);
  }

  private static String getMove(int curXPos, int newXPos) {
    if (newXPos == curXPos + 3) return "DOWN";
    if (newXPos == curXPos - 3) return "UP";
    if (newXPos == curXPos + 1) return "RIGHT";
    return "LEFT";
  }

  private static void printBoard(String board) {
    var boardChars = board.toCharArray();
    for (var i = 0; i < boardChars.length; i++) {
      out.print(boardChars[i] + " ");
      if ((i + 1) % 3 == 0) out.println();
    }
  }

  private record BoardState(String board, int xPos, int qtyMoves, List<String> moveNames) {}
}
