package chapter2.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *  Exercise 2.2.11
 *  改进的归并排序
 *  - 加快小数组排序速度，小数组使用插入排序
 *  - 检查数组是否已经有序
 *************************************************************************/

public class Ex11 {
  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];

    sort(a, 0, a.length - 1, aux);
  }

  private static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
    if (lo >= hi) return;

    // 改进1：加快小数组排序速度，小数组使用插入排序
    if (hi - lo < 15) {
      insertionSort(a, lo, hi);
    }

    int mid = lo + (hi - lo) / 2;

    sort(a, lo, mid, aux);
    sort(a, mid + 1, hi, aux);

    // 改进2：测试数组是否有序，如果a[mid] < a[mid+1]，则认为数组已经有序了，可以跳过merge方法
    if (less(a[mid + 1], a[mid])) {
      merge(a, lo, mid, hi, aux);
    }
  }

  // 改进1：加快小数组排序速度，小数组使用插入排序
  private static void insertionSort(Comparable[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++) {
      for (int j = i; j > lo; j--) {
        if (less(a[j], a[j - 1])) break;
        exch(a, j, j - 1);
      }
    }
  }

  private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
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
      } else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
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
