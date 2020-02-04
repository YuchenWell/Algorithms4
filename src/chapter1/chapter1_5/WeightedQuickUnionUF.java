package chapter1.chapter1_5;

import chapter1.chapter1_4.StopWatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
  private int[] id; // 父链接数组（以触点作为索引）
  private int[] sz; // 由触点索引的 各个根节点 对应的分量的大小
  private int count; // 连通分量的数量

  public WeightedQuickUnionUF(int N) {
    count = N;
    sz = new int[N];
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
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

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);

    if (pRoot == qRoot) return;

    if (sz[pRoot] < sz[qRoot]) {
      id[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    } else {
      id[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    }
    count--;
  }

  public static void main(String[] args) {
    /*
     * UF文件
     * - tinyUF.txt 10个触点 11条连接
     * - mediumUF.txt 625个触点 900条连接
     * - largeUF.txt 1000000个触点 2000000条连接
     */
    String filename = "algs4-data/largeUF.txt";

    In in = new In(filename);
    int N = in.readInt();
    int cnt = 0;
    UF uf = new UF(N);

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
