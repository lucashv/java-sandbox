package com.lhvsofteng.java.sandbox;

/*
Matrix=
{
	{1, 1, 1, 1},
	{0, 3, 1, 1},
	{1, 1, 1, 0},
	{2, 2, 1, 1}
}
output: 2
 */
public class CrossMatrix {
  public static void main(String[] args) {
    int[][] input =
        new int[][] {
          {1, 1, 1, 1},
          {0, 3, 1, 1},
          {1, 1, 1, 0},
          {5, 1, 1, 1}
        };
    //    int[][] input =
    //        new int[][] {
    //          {1, 2},
    //          {2, 1},
    //        };
    int result = solution(input);
    System.out.printf("Solution is %d\n", result);
  }

  public static int solution(int[][] matrix) {
    int[] rowIndex = new int[matrix.length];
    int[] colIndex = new int[matrix[0].length];

    loopX:
    for (int x = 0; x < matrix.length; x++) {
      for (int y = 0; y < matrix[0].length; y++) {
        if (y > 0) {
          int diff = Math.abs(matrix[x][y] - matrix[x][y - 1]);
          if (diff > 1) {
            continue loopX;
          }
        }
      }
      rowIndex[x] = 1;
    }

    loopY:
    for (int y = 0; y < matrix[0].length; y++) {
      for (int x = 0; x < matrix.length; x++) {
        if (x > 0) {
          int diff = Math.abs(matrix[x][y] - matrix[x - 1][y]);
          if (diff > 1) {
            continue loopY;
          }
        }
      }
      colIndex[y] = 1;
    }

    for (int row : rowIndex) System.out.printf("%d \n", row);
    System.out.println("===");
    for (int col : colIndex) System.out.printf("%d ", col);
    System.out.println("===");

    int result = 0;
    for (int row : rowIndex) {
      for (int col : colIndex) {
        result += row * col;
      }
    }

    return result;
  }
}
