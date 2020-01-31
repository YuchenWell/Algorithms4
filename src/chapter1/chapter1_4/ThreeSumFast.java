package chapter1.chapter1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {
  public static int count(int[] a) {
    Arrays.sort(a);

    int N = a.length;
    int cnt = 0;

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (BinarySearch.indexOf(a, -(a[i] + a[j])) > j) cnt++;
      }

    }
    return cnt;
  }

  public static void main(String[] args) {

    /**
     * 整数元组文件
     * - 1Kints.txt 1000个整数
     * - 2Kints.txt 2000个整数
     * - 4Kints.txt 4000个整数
     * - 8Kints.txt 8000个整数
     */
    String filename = "algs4-data/4Kints.txt";

    int[] a = new In(filename).readAllInts();
    StdOut.println(count(a));
  }
}
