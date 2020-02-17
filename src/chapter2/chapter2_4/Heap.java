package chapter2.chapter2_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Heap {
  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);

    int N = a.length;
    // Step 1: 堆的构造，使堆有序
    for (int k = N / 2; k >= 1; k--) {
      sink(a, k, N);
    }

    // Step 2: 下沉排序
    while (N > 1) {
      exch(a, 1, N--);
      sink(a, 1, N);
    }
  }

  private static void sink(Comparable[] pq, int k, int N) {
    while (k * 2 <= N) {
      int j = k * 2;
      if (j < N && less(pq, j, j + 1)) j++;
      if (less(pq, j, k)) break;

      exch(pq, j, k);
      k = j;
    }
  }

  private static boolean less(Comparable[] pq, int i, int j) {
    return pq[i - 1].compareTo(pq[j - 1]) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i - 1];
    a[i - 1] = a[j - 1];
    a[j - 1] = temp;
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a, i, i - 1)) return false;
    }
    return true;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    /*
     * 用来排序的文件
     * - tiny.txt ```S O R T E X A M P L E```
     * - words3.txt
     */
    String filename = "algs4-data/tiny.txt";

    String[] a = new In(filename).readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
