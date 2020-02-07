package chapter2.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


/*************************************************************************
 *  Ex 2.2.9
 *  线程安全的Merge类
 *  aux使用sort的局部变量
 *  （不适合在merge中使用局部变量，会创建太多局部变量，详见答疑）
 *************************************************************************/

public class Ex09 {
  public static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
    int i = lo;
    int j = mid + 1;

    for (int k = i; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = i; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
      }
    }
  }

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];

    sort(a, 0, a.length - 1, aux);
  }

  public static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
    if (lo >= hi) return;

    int mid = lo + (hi - lo) / 2;

    sort(a, lo, mid, aux);
    sort(a, mid + 1, hi, aux);
    merge(a, lo, mid, hi, aux);
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      if (less(a[i], a[i - 1])) {
        return false;
      }
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
