package chapter1.chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
  private Node first;
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private class Node {
    Item item;
    Node next;
  }

  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  /**
   * Ex1.3.7 返回最近添加的元素，而不弹出它。
   */
  public Item peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack underflow");
    }

    return first.item;
  }

  /**
   * Ex1.3.20 删除链表的第K个元素。
   */
  public Item delete(int k) {
    if (k > N) return null;

    Node current = first;
    for (int i = 1; i < N - 1; i++) {
      current = current.next;
    }
    Item item = current.next.item;
    current.next = current.next.next;
    return item;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
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
}
