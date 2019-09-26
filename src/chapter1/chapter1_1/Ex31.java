package chapter1.chapter1_1;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdIn;

public class Ex31 {
  static class Point {
    double x;
    double y;

    Point(double x, double y) {
      super();
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    // Enter points
    System.out.print("Points: ");
    int N=StdIn.readInt();
    if (N < 1 ) {
      System.out.println("Points count is not valid!");
      return;
    }

    // Enter Probability
    System.out.print("Probability:");
    double p =StdIn.readDouble();
    if (p < 0 || p > 1) {
      System.out.println("Probability is not valid!");
      return;
    }

    // Draw circle outline
    StdDraw.setPenRadius(0.01);
    Point[] points = new Point[N];
    double angle = 360.0 / N;
    StdDraw.circle(0.5, 0.5, 0.45);


    // Draw circle points
    StdDraw.setPenRadius(0.03);
    for (int i = 0; i < N; i++) {
      points[i] = new Point(0.5 + 0.45 * Math.cos(angle * i * Math.PI / 180),
        0.5 + 0.45 * Math.sin(angle * i * Math.PI / 180));
      StdDraw.point(points[i].x, points[i].y);
    }

    // Draw connect line
    StdDraw.setPenRadius(0.005);
    StdDraw.setPenColor(Color.ORANGE);
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        if (StdRandom.bernoulli(p)) {
          StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
        }
      }
    }
  }
}
