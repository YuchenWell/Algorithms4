package chapter1.chapter1_5;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ErdosRenyi {
  private static int count(int N) {
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
    int p;
    int q;
    int count = 0;

    while (uf.count() > 1) {
      p = StdRandom.uniform(N);
      q = StdRandom.uniform(N);
      if (!uf.connected(p, q)) {
        uf.union(p, q);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int N = 20000;

    StdOut.println(count(N));
  }
}
