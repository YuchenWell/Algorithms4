package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
  private Node first;
  private int N = 0;
  private int operates = 0; // Ex 1.3.50 快速出错的迭代器


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

    /**
     * Ex 1.3.42
     * 复制栈
     */
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
   * Ex 1.3.42
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
    operates++;
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
    N--;
    operates++;
    return item;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;
    operates++;
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

  /**
   * Ex1.3.47
   * 可连接的栈
   * 先弹出的是 输入的栈中的数据（因为输入的栈是后进的）。
   * 栈： 后进先出
   */
  public void cartenation(Stack<Item> stack) {
    if (stack.first == null) return;

    Stack<Item> temp = new Stack<Item>(stack);
    Node last = temp.first;
    while (last.next != null) {
      last = last.next;
    }
    last.next = first;
    first = temp.first;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;
    private int count = operates; // Ex 1.3.50 快速出错的迭代器

    public boolean hasNext() {
      // Ex 1.3.50 快速出错的迭代器
      if (count != operates) throw new ConcurrentModificationException();

      return current != null;
    }

    public void remove() {
    }

    public Item next() {
      // Ex 1.3.50 快速出错的迭代器
      if (count != operates) throw new ConcurrentModificationException();

      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Stack<String> stack1 = new Stack<String>();
    stack1.push("A");
    stack1.push("B");
    stack1.push("C");


    Stack<String> stack2 = new Stack<String>();
    stack2.push("X");
    stack2.push("Y");
    stack2.push("Z");


    StdOut.print("Stack 1: ");
    for (String string : stack1) {
      StdOut.print(string);
    }

    StdOut.println();
    StdOut.print("Stack 2: ");
    for (String string : stack2) {
      StdOut.print(string);
    }

    stack1.cartenation(stack2);

    StdOut.println();
    StdOut.print("Stack 1: ");
    for (String string : stack1) {
      StdOut.print(string);
    }

    StdOut.println();
    StdOut.print("Stack 2: ");
    for (String string : stack2) {
      StdOut.print(string);
    }
  }
}
