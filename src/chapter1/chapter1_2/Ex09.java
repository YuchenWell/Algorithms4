package chapter1.chapter1_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;


public class Ex09 {
  private static int rank(int[] a, int key, Counter counter) {
    return rank(a, key, 0, a.length - 1, counter);
  }

  private static int rank(int[] a, int key, int lo, int hi, Counter counter) {
    counter.increment();
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (a[mid] > key) {
      return rank(a, key, lo, mid - 1, counter);
    } else if (a[mid] < key) {
      return rank(a, key, mid + 1, hi, counter);
    } else {
      return mid;
    }
  }

  public static void main(String[] args) {
    int[] a = {5, 9, 3, 7, 15, 11, 4, 25, 48, 157};
    int key = 5;

    Arrays.sort(a);
    Counter counter = new Counter("keys");
    System.out.println(rank(a, key, counter));
    System.out.println(counter);
  }
}
