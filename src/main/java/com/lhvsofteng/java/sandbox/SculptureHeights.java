package com.lhvsofteng.java.sandbox;

public class SculptureHeights {
  public static void main(String[] args) {
    int[] input = new int[] {2, 7, 8, 3, 5, 2, 1, 9, 4, 15, 10, 12};
    int[] result = solution(input);

    System.out.print("Result is: ");
    printArray(result);
  }

  public static int[] solution(int[] heights) {
    int[] result = new int[heights.length];
    int resultIdx = 0;
    int size = heights.length;
    int smallerHeight = Integer.MAX_VALUE;
    int smallerHeightIdx = 0;

    while (resultIdx < result.length) {
      for (int i = 0; i < size; i++) {
        if ((i == 0 || heights[i] >= heights[i - 1])
            && (i == size - 1 || (i < size - 1 && heights[i] >= heights[i + 1]))
            && smallerHeight > heights[i]) {
          smallerHeight = heights[i];
          smallerHeightIdx = i;
        }
      }

      result[resultIdx++] = smallerHeight;
      smallerHeight = Integer.MAX_VALUE;
      removeElement(heights, size, smallerHeightIdx);
      size -= 1;
    }

    return result;
  }

  public static void removeElement(int[] heights, int currentSize, int smallerHeightIdx) {
    for (int j = smallerHeightIdx; j < currentSize; j++) {
      heights[j] = j < currentSize - 1 ? heights[j + 1] : 0;
    }
  }

  public static void printArray(int[] arr) {
    for (int i : arr) System.out.printf("%d ", i);
  }
}
