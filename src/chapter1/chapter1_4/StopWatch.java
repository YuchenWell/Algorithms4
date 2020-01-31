package chapter1.chapter1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 一种表示计时器的抽象数据类型。
 */
public class StopWatch {
  private final long start;
  public String name;

  public StopWatch() {
    start = System.currentTimeMillis();
  }

  public StopWatch(String name) {
    name = name;
    start = System.currentTimeMillis();
  }

  public double elapsedTime() {
    long now = System.currentTimeMillis();
    return (now - start) / 1000.0;
  }

  public static void main(String[] args) {
    int length = 2000;
    int[] a = new int[length];

    for (int i = 0; i < length; i++) {
      a[i] = StdRandom.uniform(-1000000, 1000000);
    }
    StopWatch timer = new StopWatch("ThreeSum");
    int cnt = ThreeSum.count(a);
    double time = timer.elapsedTime();
    StdOut.println(cnt + " triples, " + time + " seconds");

  }
}
