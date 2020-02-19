package chapter2.chapter2_4;

import edu.princeton.cs.algs4.StdOut;

public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int N = 0;

  public UnorderedArrayMaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN];
  }

  public void insert(Key v) {
    pq[N++] = v;
  }

  public Key delMax() {
    if (N == 0) return null;

    Key max = pq[0];
    int index = 0;

    for (int i = 1; i < N; i++) {
      if (pq[i].compareTo(max) > 0) {
        max = pq[i];
        index = i;
      }
    }

    pq[index] = pq[N - 1];
    pq[N - 1] = null;
    N--;
    return max;
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
    UnorderedArrayMaxPQ<Integer> pq = new UnorderedArrayMaxPQ<>(100);

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
