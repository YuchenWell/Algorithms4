package chapter2.chapter2_4;

import edu.princeton.cs.algs4.StdOut;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0;

  public OrderedArrayMaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN];
  }

  public void insert(Key v) {
    pq[N++] = v;

    for (int i = N - 2; i >= 0; i--) {
      if (pq[i + 1].compareTo(pq[i]) >= 0) break;
      exch(i, i + 1);
    }
  }

  public Key delMax() {
    Key v = pq[N - 1];
    pq[--N] = null;
    return v;
  }

  private void exch(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void show() {
    for (int i = 0; i < N; i++) {
      StdOut.print(pq[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    OrderedArrayMaxPQ<Integer> pq = new OrderedArrayMaxPQ<>(100);

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
