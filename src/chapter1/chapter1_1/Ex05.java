package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex05 {
  public static void main(String[] args) {
    double x = StdIn.readDouble();
    double y = StdIn.readDouble();
    boolean b = x > 0.0 && x <= 1.0 && y > 0.0 && y < 1.0;
    System.out.println(b);
  }
}
