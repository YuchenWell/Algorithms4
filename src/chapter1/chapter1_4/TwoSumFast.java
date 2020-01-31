package chapter1.chapter1_4;

import chapter1.chapter1_1.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {
  public static int count(int[] a) {
    Arrays.sort(a);

    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      if (BinarySearch.indexOf(a, -a[i]) > i) cnt++;
    }
    return cnt;
  }

  public static void main(String[] args) {

    /*
     * 整数元组文件
     * - 1Kints.txt 1000个整数
     * - 2Kints.txt 2000个整数
     * - 4Kints.txt 4000个整数
     * - 8Kints.txt 8000个整数
     */
    String filename = "algs4-data/8Kints.txt";

    int[] a = new In(filename).readAllInts();
    StdOut.println(count(a));
  }
}
