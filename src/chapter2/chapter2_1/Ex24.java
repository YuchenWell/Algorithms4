package chapter2.chapter2_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *  Exercise 1.2.24
 *  规避边界测试的插入排序
 *  大数组下大概能快7%，小数组小更慢
 *************************************************************************/

public class Ex24 {
  public static void sort(Comparable[] a) {
    int N = a.length;

    for (int i = N - 1; i > 0; i--) {
      if (less(a[i], a[i - 1])) exch(a, i, i - 1);
    }

    for (int i = 1; i < N; i++) {
      for (int j = i; true; j--) {
        if (less(a[j - 1], a[j])) break;
        exch(a, j, j - 1);
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
    for (Comparable comparable : a) {
      StdOut.print(comparable + " ");
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
