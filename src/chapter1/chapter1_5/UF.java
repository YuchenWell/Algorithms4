package chapter1.chapter1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class UF {
  private int[] id; // 分量id（以触点作为索引）
  private int count; // 分量数量

  public UF(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    // 如果p和q已经在相同的分量之中则不需要采取任何处理
    if (pID == qID) return;

    // 将p的分量重命名为q的名称；
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) id[i] = qID;
    }

    count--;
  }

  public boolean connected2(int p, int q) {
    return find2(p) == find2(q);
  }

  private int find2(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public void union2(int p, int q) {
    int pRoot = find2(p);
    int qRoot = find2(q);

    if (pRoot == qRoot) return;

    id[pRoot] = qRoot;
    count--;
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
    UF uf = new UF(N);

    while (!in.isEmpty()) {
      int p = in.readInt();
      int q = in.readInt();

      if (uf.connected(p, q)) continue;
      uf.union2(q, p);
//      StdOut.println(p + " " + q);
    }

    StdOut.println(uf.count() + " components");

  }
}
