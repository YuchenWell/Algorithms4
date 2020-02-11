package chapter2.chapter2_1;

import chapter2.chapter2_2.Merge;
import chapter2.chapter2_3.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortComparable {
  public static double time(String alg, Double[] a) {
    Stopwatch timer = new Stopwatch();
    switch (alg) {
      case "Selection":
        Selection.sort(a);
      case "Insertion":
        Insertion.sort(a);
      case "Shell":
        Shell.sort(a);
      case "Ex24":
        Ex24.sort(a);
      case "Merge":
        Merge.sort(a);
      case "Quick":
        Quick.sort(a);
    }
    return timer.elapsedTime();
  }

  public static double timeRandomInput(String alg, int N, int T) {
    //使用算法alg将T个长度为N的数组排序
    double total = 0.0;
    Double[] a = new Double[N];
    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = StdRandom.uniform();
      }
      total += time(alg, a);
    }
    return total;
  }

  public static void main(String[] args) {
    String alg1 = "Selection";
    String alg2 = "Insertion";
    String alg3 = "Shell";
    String alg4 = "Merge";
    String alg5 = "Quick";

    int N = 5000; // 数组长度
    int T = 100; // 测试数量

    StdOut.printf("For %d random Doubles:\n", N, alg1);

    double t1 = timeRandomInput(alg1, N, T);
    StdOut.printf("%s used  %.2f seconds \n", alg1, t1);

    double t2 = timeRandomInput(alg2, N, T);
    StdOut.printf("%s used  %.2f seconds \n", alg2, t2);

    double t3 = timeRandomInput(alg3, N, T);
    StdOut.printf("%s used  %.2f seconds \n", alg3, t3);

    double t4 = timeRandomInput(alg4, N, T);
    StdOut.printf("%s used  %.2f seconds \n", alg4, t4);

    double t5 = timeRandomInput(alg5, N, T);
    StdOut.printf("%s used  %.2f seconds \n", alg5, t5);
  }
}
