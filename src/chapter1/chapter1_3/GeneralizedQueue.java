package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/*************************************************************************
 * Ex 1.3.38
 * 泛型一般队列 链表实现
 * 可以删除第k个元素
 *************************************************************************/

public class GeneralizedQueue<Item> implements Iterable<Item> {
  private int N = 0;
  private Node first;
  private Node last;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(Item item) {
    Node node = new Node();
    node.item = item;
    node.next = null;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      last.next = node;
      last = node;
    }
    N++;
  }

  public Item delete(int k) {
    if (k < 0 || k >= N) return null;

    Node prev = first;
    for (int i = 1; i < k; i++) {
      prev = prev.next;
    }
    Item item = prev.next.item;
    if (k == N - 1) {
      prev.next = null;
    } else {
      prev.next = prev.next.next;
    }

    N--;
    return item;
  }


  public Iterator<Item> iterator() {
    return new GeneralizedQueueIterator();
  }

  private class GeneralizedQueueIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
    }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    GeneralizedQueue<String> queue = new GeneralizedQueue<String>();

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
