package chapter1.chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Ex1.4.39
 * DoublingRatio 改进倍率测试的精度
 */
public class DoublingRatio {
  public static double timeTrail(int N) {
    int[] a = new int[N];

    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.uniform(-1000000, +1000000);
    }

    StopWatch timer = new StopWatch();
    int cnt = ThreeSumFast.count(a);
    return timer.elapsedTime();
  }

  public static void main(String[] args) {
    double prev = timeTrail(500);

    for (int N = 1000; N <= 100000; N += N) {
      double time = timeTrail(N);
      StdOut.printf("%7d %8.3f %5.2f\n", N, time, time / prev);
      prev = time;
    }
  }
}
