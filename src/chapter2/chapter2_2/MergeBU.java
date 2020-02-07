package chapter2.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MergeBU {
  private static Comparable[] aux;

  public static void sort(Comparable[] a) {
    int N = a.length;
    aux = new Comparable[N];

    for (int sz = 1; sz < N; sz += sz) {
      for (int lo = 0; lo < N - sz; lo += 2 * sz) {
        merge(a, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
      }
    }
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
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
