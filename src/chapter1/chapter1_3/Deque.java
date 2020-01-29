package chapter1.chapter1_3;


import java.util.Iterator;

/*************************************************************************
 *  Exercise 1.3.33
 *  双向队列
 *  同时支持两端添加和删除元素。
 *************************************************************************/

public class Deque<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int N = 0;

  public class Node {
    Item item;
    Node next;
    Node prev;
  }

  public Deque() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  /**
   * 类似于Stack的push
   */
  public void pushLeft(Item item) {
    Node node = new Node();
    node.item = item;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      node.next = first;
      first.prev = node;
      first = node;
    }
    N++;
  }

  /**
   * 类似于Queue的enqueue
   */
  public void pushRight(Item item) {
    Node node = new Node();
    node.item = item;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      last.next = node;
      node.prev = last;
      last = node;
    }
    N++;
  }

  /**
   * 类似Stack的pop或者Queue的dequeue
   */
  public Item popLeft() {
    if (isEmpty()) throw new RuntimeException("List is empty");

    Item item = first.item;

    if (first.next != null) {
      first = first.next;
      first.prev = null;
    } else {
      first = null;
    }
    N--;
    return item;
  }

  public Item popRight() {
    if (isEmpty()) throw new RuntimeException("List is empty");

    Item item = last.item;
    if (last.prev != null) {
      last.prev.next = null;
      last = last.prev;
    } else {
      last = null;
    }
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new DequeIterator();
  }

  private class DequeIterator implements Iterator<Item> {
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
    Deque<String> deque = new Deque<String>();
    deque.pushLeft("A");
    deque.pushLeft("B");
    deque.pushLeft("C");
    deque.pushLeft("D");

    System.out.println();
    for (String string : deque) {
      System.out.print(string);
      // Linked list: DCBA
      // Output: DCBA
    }

    deque.pushRight("E");
    deque.pushRight("F");
    deque.pushRight("G");
    deque.pushRight("H");

    System.out.println();
    for (String string : deque) {
      System.out.print(string);
      // Linked list: DCBAEFGH
      // Output: DCBAEFGH
    }

    deque.popLeft();
    deque.popLeft();
    deque.popRight();
    deque.popRight();

    System.out.println();
    for (String string : deque) {
      System.out.print(string);
      // Linked list: BAEF
      // Output: BAEF
    }


  }
}
