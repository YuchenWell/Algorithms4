package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex21 {
  public static void main(String[] args) {
    System.out.print("Pleas input rows: ");
    int rows = StdIn.readInt();

    String[] names = new String[rows];
    int[] int1 = new int[rows];
    int[] int2 = new int[rows];
    double[] avg = new double[rows];

    for (int i = 0; i < rows; i++) {
      System.out.print("Pleas input row " + i + " name: ");
      names[i] = StdIn.readString();
      System.out.print("Pleas input row " + i + " int 1: ");
      int1[i] = StdIn.readInt();
      System.out.print("Pleas input row " + i + " int 2: ");
      int2[i] = StdIn.readInt();

      avg[i] = (double) int1[i] / int2[i];
    }

    System.out.println("┌------┬----┬----┬-----┐");
    for (int i = 0; i < rows; i++) {
      System.out.printf("|%5s|%4d|%4d|%6.3f|\n", names[i], int1[i], int2[i], avg[i]);
      System.out.println("------------------------");
    }

  }
}
