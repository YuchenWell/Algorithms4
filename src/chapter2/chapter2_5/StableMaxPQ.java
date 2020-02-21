package chapter2.chapter2_5;

import edu.princeton.cs.algs4.StdOut;

public class StableMaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0;
  private int[] time;
  private int timestamp;

  public StableMaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
    time = new int[maxN];
    timestamp = 0;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Key v) {
    pq[++N] = v;
    time[N] = ++timestamp; // 相比不稳定版的MaxPQ增加记录插入键值的顺序
    swim(N);
  }

  public Key delMax() {
    Key max = pq[1];
    exch(1, N--);
    pq[N + 1] = null;

    time[N + 1] = 0;

    sink(1);
    return max;
  }

  private boolean less(int i, int j) {
    // 先比较键的大小，如果大小相同，则比较插入时间，时间大的键也比较大
    if (pq[i].compareTo(pq[j]) < 0) {
      return true;
    } else if (pq[i].compareTo(pq[j]) > 0) {
      return false;
    } else {
      return time[i] < time[j];
    }
  }

  private void exch(int i, int j) {
    Key t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;

    // 记录时间的数组也要调换位置
    int temp = time[i];
    time[i] = time[j];
    time[j] = temp;
  }

  private void swim(int k) {
    // swim方法与不稳定版的MaxPQ一样
    while (k > 1 && less(k / 2, k)) {
      exch(k / 2, k);
      k = k / 2;
    }
  }

  private void sink(int k) {
    // sink方法与不稳定版的MaxPQ一样
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) j++;
      if (less(j, k)) break;
      exch(k, j);
      k = j;
    }
  }

  private void show() {
    for (int i = 1; i <= N; i++) {
      StdOut.print(pq[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    StableMaxPQ<Integer> pq = new StableMaxPQ<>(100);

    pq.insert(5);
    pq.insert(4);
    pq.insert(2);
    pq.insert(1);
    pq.insert(8);
    pq.insert(5);
    pq.insert(7);
    pq.insert(3);
    pq.insert(9);
    pq.insert(6);

    pq.show();

    for (int i = 1; i <= 10; i++) {
      StdOut.print(pq.delMax() + " ");
    }
  }
}
