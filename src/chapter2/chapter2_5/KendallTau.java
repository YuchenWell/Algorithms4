package chapter2.chapter2_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Kendall tau距离就是两个排列之间的逆序数，它反映了两个排列的相似程度。
 * 例如两个在区间[ 0 , 6 ]的排列a和b, 求a，b的Kendall tau距离:
 * - a = { 0, 3, 1, 6, 2, 5, 4 }
 * - b = { 1, 0, 3, 6, 4, 2, 5 }
 * 就是求两个排列之间的逆序{ 0，1 }，{ 3，1 }，{ 2，4 }，{ 5，4 }，
 * 一共为4对，故Kendall tau距离为4。
 */
public class KendallTau {

  public static int distance(int[] a, int[] b) {
    int n = a.length;

    int[] aIndex = new int[n];

    for (int i = 0; i < n; i++) {
      aIndex[a[i]] = i;
    }
    Integer[] bIndexInA = new Integer[n];
    for (int i = 0; i < n; i++) {
      bIndexInA[i] = aIndex[b[i]];
    }

    return Ex2_2_19.count(bIndexInA);
  }

  public static void main(String[] args) {
    // 数组元素的个数
    int n = StdIn.readInt();

    // 生成两个比较的数组
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = i;
      b[i] = i;
    }

    // 打乱数组a，并打印
    StdRandom.shuffle(a);
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();

    // 打乱数组b，并打印
    StdRandom.shuffle(b);
    for (int i = 0; i < n; i++) {
      System.out.print(b[i] + " ");
    }
    System.out.println();

    // 打印两个数组的Kendall tau距离
    System.out.println("distance: " + distance(a, b));
  }
}
