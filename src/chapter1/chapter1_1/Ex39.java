package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Ex39 {
  private static int binarySearch(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (a[mid] > key) {
        hi = mid - 1;
      } else if (a[mid] < key) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  private static int getAverage(int N, int T) {
    int total = 0;
    for (int i = 1; i <= T; i++) {
      int[] a1 = randomArray(N);
      int[] a2 = randomArray(N);
      total += duplicate(a1, a2);
    }
    return total / T;
  }

  private static int[] randomArray(int N) {
    int[] result = new int[N];
    for (int i = 0; i < result.length; i++) {
      result[i] = StdRandom.uniform(100000, 1000000);
    }
    return result;
  }

  private static int duplicate(int[] a1, int[] a2) {
    int result = 0;
    Arrays.sort(a2);
    for (int key : a1) {
      if (binarySearch(key, a2) != -1) result++;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.print("Test times(T): ");
    int T = StdIn.readInt();

    System.out.print("N = 1000, Avg = ");
    System.out.print(getAverage(1000, T));
    System.out.println();

    System.out.print("N = 10000, Avg = ");
    System.out.print(getAverage(10000, T));
    System.out.println();

    System.out.print("N = 100000, Avg = ");
    System.out.print(getAverage(100000, T));
    System.out.println();

    System.out.print("N = 1000000, Avg = ");
    System.out.print(getAverage(1000000, T));
    System.out.println();
  }
}
