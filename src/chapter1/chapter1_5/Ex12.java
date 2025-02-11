package chapter1.chapter1_5;

import chapter1.chapter1_4.StopWatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Ex 1.5.12
 * 路径压缩的QuickUnion算法
 */

public class Ex12 {
  private int[] id;  // 父链接数组（以触点作为索引）
  private int count;


  public Ex12(int N) {
    count = N;
    id = new int[N];

    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  private int find(int p) {
    int root = p;
    while (id[root] != root) {
      root = id[root];
    }

    while (id[p] != root) {
      int temp = p;
      p = id[p];
      id[temp] = root;
    }

    return root;
  }

  private void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    if (pRoot == qRoot) return;

    id[pRoot] = qRoot;
    count--;
  }

  private int count() {
    return count;
  }

  private boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public static void main(String[] args) {
    /*
     * UF文件
     * - tinyUF.txt 10个触点 11条连接
     * - mediumUF.txt 625个触点 900条连接
     * - largeUF.txt 1000000个触点 2000000条连接
     */
    String filename = "algs4-data/mediumUF.txt";

    In in = new In(filename);
    int N = in.readInt();
    int cnt = 0;
    Ex12 uf = new Ex12(N);

    StopWatch timer = new StopWatch();
    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();
      cnt++;

      if (cnt % 10000 == 0) {
        StdOut.printf("%s in %6.2f seconds \n", cnt, timer.elapsedTime());
      }
      if (uf.connected(p, q)) continue;
      uf.union(q, p);
    }

    StdOut.println(uf.count() + " components");
    StdOut.println(timer.elapsedTime() + " seconds");
  }
}
