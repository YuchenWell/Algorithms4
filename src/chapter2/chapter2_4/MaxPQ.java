package chapter2.chapter2_4;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0;

  public MaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (k * 2 <= N) {
      int j = k * 2;
      if (j < N && less(j, j + 1)) j++;
      if (less(j, k)) break;
      exch(j, k);
      k = j;
    }
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Key v) {
    pq[++N] = v;
    swim(N);
  }

  public Key delMax() {
    Key max = pq[1];
    pq[1] = pq[N];
    pq[N--] = null;

    sink(1);
    return max;
  }

  private void show() {
    for (int i = 1; i <= N; i++) {
      StdOut.print(pq[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    MaxPQ<Integer> pq = new MaxPQ<>(100);

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
