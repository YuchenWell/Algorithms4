package chapter2.chapter2_1;

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
    }
    return timer.elapsedTime();
  }

  public static double timeRandomInput(String alg, int N, int T) {
    //使用算法algT个长度为N的数组排序
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
    String alg1 = "Insertion";
    String alg2 = "Selection";
    int N = 5000; // 数组长度
    int T = 10; // 测试数量

    double t1 = timeRandomInput(alg1, N, T);
    double t2 = timeRandomInput(alg2, N, T);

    StdOut.printf("For %d random Doubles\n %s is ", N, alg1);
    StdOut.printf("%.2f times faster than %s\n", t2 / t1, alg2);
  }

}
