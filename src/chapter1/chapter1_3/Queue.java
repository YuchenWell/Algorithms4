package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

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

  /**
   * Ex1.3.47
   * 可连接的队列
   * 先弹出的是 原来队列中的数据（因为输入的队列是后进的）。
   * 队列： 先进先出
   */
  public void cartenation(Queue<Item> queue) {
    if (queue.first == null) return;

    Queue<Item> temp = new Queue<Item>(queue);
    last.next = temp.first;
    last = temp.last;
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

  public static void main(String[] args) {
    Queue<String> queue1 = new Queue<String>();
    queue1.enqueue("A");
    queue1.enqueue("B");
    queue1.enqueue("C");


    Queue<String> queue2 = new Queue<String>();
    queue2.enqueue("X");
    queue2.enqueue("Y");
    queue2.enqueue("Z");


    StdOut.print("Queue 1: ");
    for (String string : queue1) {
      StdOut.print(string);
    }

    StdOut.println();
    StdOut.print("Queue 2: ");
    for (String string : queue2) {
      StdOut.print(string);
    }

    queue1.cartenation(queue2);

    StdOut.println();
    StdOut.print("Queue 1: ");
    for (String string : queue1) {
      StdOut.print(string);
    }

    StdOut.println();
    StdOut.print("Queue 2: ");
    for (String string : queue2) {
      StdOut.print(string);
    }
  }
}
