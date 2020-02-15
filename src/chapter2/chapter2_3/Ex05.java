package chapter2.chapter2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/*************************************************************************
 *  Ex 2.3.05
 *  简化版的三向切分的快速排序
 *  在被排序数组只有两种键值的情况下：
 *  - 比标准的快速排序快200%
 *  - 比标准的三向切分的快速排序快3%左右
 *************************************************************************/

public class Ex05 {
  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);

    int lt = 0;
    int i = 1;
    int gt = a.length - 1;

    while (i <= gt) {
      int cmp = a[i].compareTo(a[lt]);
      if (cmp > 0) {
        exch(a, i, gt--);
      } else if (cmp < 0) {
        exch(a, i++, lt++);
      } else {
        i++;
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

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i - 1])) return false;
    }
    return true;
  }


  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    Integer[] a = new Integer[5000000];

    for (int i = 0; i < a.length; i++) {
      a[i] = Math.random() > 0.5 ? 1 : 2;
    }

    Stopwatch timer1 = new Stopwatch();
    Quick.sort(a);
    StdOut.println("标准的快速排序算法: " + timer1.elapsedTime() + " second");

    Stopwatch timer2 = new Stopwatch();
    Quick3way.sort(a);
    StdOut.println("三向切分的快速排序算法: " + timer2.elapsedTime() + " second");

    Stopwatch timer3 = new Stopwatch();
    sort(a);
    StdOut.println("Ex 2.3.05 简化版的三向切分快速排序: " + timer3.elapsedTime() + " second");
  }
}
