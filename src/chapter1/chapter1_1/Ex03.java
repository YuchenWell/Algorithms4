package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex03 {
  public static void main(String[] args) {
    int a = StdIn.readInt();
    int b = StdIn.readInt();
    int c = StdIn.readInt();

    System.out.println(a == b && b == c ? "equal" : "not equal");
  }
}
