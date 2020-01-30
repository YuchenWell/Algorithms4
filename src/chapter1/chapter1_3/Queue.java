package chapter1.chapter1_3;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int N = 0;

  private class Node {
    Item item;
    Node next;

    Node() {
    }

    /**
     * Ex 1.3.41
     * 复制队列
     */
    Node(Node x) {
      item = x.item;
      if (x.next != null) {
        next = new Node(x.next);
      } else {
        last = x;
      }
      N++;
    }
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }


  public Queue() {
    first = null;
    last = null;
    N = 0;
  }

  /**
   * Ex 1.3.41
   * 复制队列
   */
  public Queue(Queue<Item> q) {
    first = new Node(q.first);
  }

  public void enqueue(Item item) {
    Node oldLast = last;

    last = new Node();
    last.item = item;
    last.next = null;

    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }

    N++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    if (isEmpty()) last = null;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    public Node current = first;

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
}
