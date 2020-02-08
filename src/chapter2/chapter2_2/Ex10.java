package chapter2.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *  Exercise 2.2.10
 *  规避边界测试的快速归并排序
 *  减少了检测某半边是否用尽的判断
 *  规避边界测试的插入排序算法见 Ex 2.1.24
 *************************************************************************/

public class Ex10 {
  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, 0, a.length - 1, aux);
  }

  private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
    if (lo >= hi) return;

    int mid = lo + (hi - lo) / 2;

    sort(a, lo, mid, aux);
    sort(a, mid + 1, hi, aux);
    merge(a, lo, mid, hi, aux);
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
    int i = lo;
    int j = hi; // changed

    // 右半部分升序
    for (int k = lo; k <= mid; k++) {
      aux[k] = a[k];
    }

    // 左半部分降序序
    for (int k = mid + 1; k <= hi; k++) {
      aux[k] = a[mid + 1 + hi - k];
    }

    // 减少了两次判断
    for (int k = i; k <= hi; k++) {
      if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j--]; // changed
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
