package chapter1.chapter1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

public class Ex38 {
  private static int rankBruteSearch(int key, int[] a) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == key) return i;
    }
    return -1;
  }

  private static int rankBinarySearch(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (a[mid] > key) {
        hi--;
      } else if (a[mid] < key) {
        lo++;
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] whitelist = in.readAllInts();
    Arrays.sort(whitelist);

    System.out.print("Enter key: ");
    int key = StdIn.readInt();

    long startTime = System.currentTimeMillis();
    int rank1=rankBruteSearch(key, whitelist);
    System.out.println("Brute force search retrun rank: " + rank1);
    long endTime = System.currentTimeMillis();
    System.out.println("Brute force search time: " + (endTime - startTime));

    startTime = System.currentTimeMillis();
    int rank2=rankBinarySearch(key, whitelist);
    System.out.println("Binary search retrun rank: " + rank2);
    endTime = System.currentTimeMillis();
    System.out.println("Binary search time: " + (endTime - startTime));

  }
}
