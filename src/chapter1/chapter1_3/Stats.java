package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {
  public static void main(String[] args) {
    Bag<Double> numbers = new Bag<Double>();

    while (!StdIn.isEmpty()) {
      Double num = Double.parseDouble(StdIn.readString());
      numbers.add(num);
    }

    int N = numbers.size();
    double sum = 0.0;
    for (double num : numbers) {
      sum += num;
    }
    double mean = sum / N;

    StdOut.printf("Mean: %.2f", mean);
  }
}
