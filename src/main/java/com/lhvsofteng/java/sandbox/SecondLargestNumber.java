package com.lhvsofteng.java.sandbox;

public class SecondLargestNumber {
  public static void main(String[] args) {
    int[] numbers = new int[] {2, 3, 1, 4, 6, 5, 10, 18, 15, 21};
    Integer secondLargest = findSecondLargest(numbers);
    System.out.println(secondLargest);

    numbers = new int[] {1, 3, 4, 5, 0, 2};
    secondLargest = findSecondLargest(numbers);
    System.out.println(secondLargest);

    numbers = new int[] {-2, -1};
    secondLargest = findSecondLargest(numbers);
    System.out.println(secondLargest);

    numbers = new int[] {2, 2, 1};
    secondLargest = findSecondLargest(numbers);
    System.out.println(secondLargest);

    numbers = new int[] {2};
    secondLargest = findSecondLargest(numbers);
    System.out.println(secondLargest);

    numbers = new int[] {};
    secondLargest = findSecondLargest(numbers);
    System.out.println(secondLargest);
  }

  public static Integer findSecondLargest(int[] numbers) {
    if (numbers == null || numbers.length == 0 || numbers.length == 1) {
      return null;
    }
    Integer largest = null;
    Integer secondLargest = null;
    for (int number : numbers) {
      if (largest == null || number > largest) {
        secondLargest = largest;
        largest = number;
      } else if (secondLargest == null || number > secondLargest) {
        secondLargest = number;
      }
    }
    return secondLargest;
  }
}
