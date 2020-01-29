package chapter1.chapter1_3;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int N;

  public class Node {
    Item item;
    Node next;
  }


  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    Node node = new Node();
    node.item = item;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      node.next = first;
      first = node;
    }
    N++;
  }

  public Item pop() {
    if (isEmpty()) return null;

    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public void enqueue(Item item) {
    Node node = new Node();
    node.item = item;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      last.next = node;
      last = node;
    }
    N++;
  }

  public Iterator<Item> iterator() {
    return new StequeIterator();
  }

  private class StequeIterator implements Iterator<Item> {
    Node current = first;

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
    Steque<String> stringSteque1 = new Steque<String>();
    stringSteque1.enqueue("A");
    stringSteque1.enqueue("B");
    stringSteque1.enqueue("C");
    stringSteque1.enqueue("D");
    stringSteque1.enqueue("E");

    for (String string : stringSteque1) {
      System.out.print(string);
    }

    Steque<String> stringSteque2 = new Steque<String>();
    stringSteque2.push("A");
    stringSteque2.push("B");
    stringSteque2.push("C");
    stringSteque2.push("D");
    stringSteque2.push("E");

    System.out.println();
    for (String string : stringSteque2) {
      System.out.print(string);
    }

  }


}
