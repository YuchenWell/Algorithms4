package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


/*************************************************************************
 *  Exercise 1.3.29
 *  环形链表实现Queue
 *************************************************************************/

public class CircularQueue<Item> implements Iterable<Item> {
  Node first;
  Node last;
  int N = 0;

  class Node {
    Item item;
    Node next;
  }

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void enqueue(Item item) {
    Node oldLast = last;

    last = new Node();
    last.item = item;
    last.next = first;


    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }

    N++;
  }

  public Item dequeue() {
    Node oldFirst = first;
    first = oldFirst.next;
    last.next = first;
    N--;
    return oldFirst.item;
  }


  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;
    private int i = N;

    public boolean hasNext() {
      return i-- > 0;
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
    CircularQueue<String> cq = new CircularQueue<String>();
    cq.enqueue("A");
    cq.enqueue("B");
    cq.enqueue("C");
    cq.enqueue("D");

    for (String str : cq) {
      StdOut.print(str);
    }

  }
}
