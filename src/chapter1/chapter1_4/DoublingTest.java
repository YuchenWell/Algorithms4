package chapter1.chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
  public static double timeTrail(int N) {
    int[] a = new int[N];

    for (int i = 0; i < N; i++) {
      a[i] = StdRandom.uniform(-1000000, +1000000);
    }

    StopWatch timer = new StopWatch();
    int cnt = ThreeSum.count(a);
    return timer.elapsedTime();
  }

  public static void main(String[] args) {
    for (int N = 250; N <= 10000; N += N) {
      double time = timeTrail(N);
      StdOut.printf("%7d %8.3f\n", N, time);
    }
  }
}
