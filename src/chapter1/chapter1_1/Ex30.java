package chapter1.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex30 {
  private static int num = 0;
  private static int[][] cache;

  private static int euclid(int a, int b) {
    num++;
    if (a < b) {
      int t = b;
      b = a;
      a = t;
    }

    if (b == 0) {
      System.out.println("0---" + a);
      return a;
    }


    if (cache[b][a % b] == -1) {
      cache[b][a % b] = euclid(b, a % b);
    }
    return cache[b][a % b];
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();

    cache = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        cache[i][j] = -1;
      }
    }

    boolean[][] a = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        a[i][j] = euclid(i, j) == 1;
        System.out.print((a[i][j] ? 1 : 0) + "|");
      }
      System.out.println();
    }
    System.out.println("Cache: --------------------------------------------------------------");

    System.out.printf("%2s | ", "");
    for (int j = 0; j < N; j++) {
      System.out.printf("%2s | ", j);
    }
    System.out.println();

    for (int i = 0; i < N; i++) {
      System.out.printf("%2s | ", i);
      for (int j = 0; j < N; j++) {
        System.out.printf("%2s | ", cache[i][j]);
      }
      System.out.println();
    }
    System.out.println("Call times: " + num);
  }

}
