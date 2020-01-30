package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

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

    Node() {
    }

    Node(Node x) {
      item = x.item;
      if (x.next != null) {
        next = new Node(x.next);
      }
      N++;
    }


  }

  public Stack() {
    first = null;
    N = 0;
  }

  /**
   * Ex 1.3.41
   * 复制栈
   */
  public Stack(Stack<Item> s) {
    first = new Node(s.first);
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


  /**
   * Ex1.3.30 反转链表（迭代方式）。
   */
  public void reverse() {
    Node oldFirst = first;
    Node reverse = null;
    while (oldFirst != null) {
      Node second = oldFirst.next;
      oldFirst.next = reverse;
      reverse = oldFirst;
      oldFirst = second;
    }
    first = reverse;
  }

  /**
   * Ex1.3.30 反转链表（递归方式）。
   */
  public Node reverse(Node first) {
    if (first == null) return null;
    if (first.next == null) return first;

    Node second = first.next;
    Node rest = reverse(second);
    second.next = first;
    first.next = null;
    return rest;
  }

  public void reverse2() {
    first = reverse(first);
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

  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();
    stack.push("A");
    stack.push("B");
    stack.push("C");
    stack.push("D");

    for (String s : stack) {
      StdOut.print(s);
    }

    stack.reverse2();
    StdOut.println();
    for (String s : stack) {
      StdOut.print(s);
    }
  }
}
