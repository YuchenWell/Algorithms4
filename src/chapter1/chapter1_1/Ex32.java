package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdStats;

/*
 * % java Ex32 500 0 1000000 < largeT.txt
 * */
public class Ex32 {
  private static void histogram(double[] values, int n, double l, double r) {
    int[] counts = new int[n];
    double w = (r - l) / n;

    for (double value : values) {
      if (value >= l && value <= r) {
        int gap = (int) ((value - l) / w);
        counts[gap]++;
      }
    }

    // Drawing canvas setting
    double max = StdStats.max(counts);
    StdDraw.setXscale(l, r);
    StdDraw.setYscale(0, max);

    // Draw rectangle
    for (int i = 0; i < n; i++) {
      double x = l + w * (i + 0.5);
      double y = counts[i] / 2.0;
      double rw = w / 2.0;
      double rh = counts[i] / 2.0;
      StdDraw.filledRectangle(x, y, rw, rh);
    }

  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    double l = Double.parseDouble(args[1]);
    double r = Double.parseDouble(args[2]);

    double[] value = StdIn.readAllDoubles();

    histogram(value, n, l, r);
  }
}
