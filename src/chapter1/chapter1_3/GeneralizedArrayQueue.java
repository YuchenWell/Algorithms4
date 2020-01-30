package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/*************************************************************************
 * Ex 1.3.38
 * 泛型一般队列 数组实现
 * 可以删除第k个元素
 *************************************************************************/

public class GeneralizedArrayQueue<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void insert(Item item) {
    if (a.length == N) resize(N * 2);
    a[N++] = item;
  }

  public Item delete(int k) {
    if (k < 0 || k >= N) return null;

    Item item = a[k];
    if (a.length == N) {
      a[N--] = null;
      return item;
    }
    for (int i = k; i < N - 1; i++) {
      a[i] = a[i + 1];
    }
    a[N - 1] = null;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new GeneralizedArrayQueueIterator();
  }

  private class GeneralizedArrayQueueIterator implements Iterator<Item> {
    private int n = 0;

    public boolean hasNext() {
      return n < N;
    }

    public void remove() {
    }

    public Item next() {
      return a[n++];
    }

  }

  public static void main(String[] args) {
    GeneralizedArrayQueue<String> queue = new GeneralizedArrayQueue<String>();

    queue.insert("A");
    queue.insert("B");
    queue.insert("C");
    queue.insert("D");
    queue.insert("E");

    StdOut.println("Original: ");
    for (String str : queue) {
      StdOut.print(str);
    }

    queue.delete(2);
    queue.delete(10);
    queue.delete(-1);
    queue.delete(3);
    queue.delete(2);

    StdOut.println();
    StdOut.println("Deleted: ");
    for (String str : queue) {
      StdOut.print(str);
    }
  }
}
