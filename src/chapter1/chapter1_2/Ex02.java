package chapter1.chapter1_2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;

public class Ex02 {
  public static void main(String[] args) {
    System.out.print("N: ");
    int N = StdIn.readInt();

    Interval1D[] intervals = new Interval1D[N];

    for (int i = 1; i <= N; i++) {
      System.out.print("Interval " + i + " (lo):");
      double lo = StdIn.readDouble();
      System.out.print("Interval " + i + " (hi):");
      double hi = StdIn.readDouble();
      intervals[i - 1] = new Interval1D(lo, hi);
    }

    if (N > 2) {
      for (int i = 0; i < N - 1; i++) {
        for (int j = i + 1; j < N; j++) {
          if (intervals[i].intersects(intervals[j])) {
            System.out.println(intervals[i] + " intersects " + intervals[j]);
          }
        }
      }
    }


  }
}
