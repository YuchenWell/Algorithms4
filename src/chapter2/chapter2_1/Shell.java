package chapter2.chapter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Shell {
  public static void sort(Comparable[] a) {
    int N = a.length;
    int h = 0;

    while (h < N / 3) {
      h = h * 3 + 1; // 1, 4, 13, 40, 121, 364, ...
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h; j -= h) {
          if (less(a[j], a[j - h])) break;
          exch(a, j, j - h);
        }
      }
      h /= 3;
    }

  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) > 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
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
