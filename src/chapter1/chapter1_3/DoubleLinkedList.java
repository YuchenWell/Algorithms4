package chapter1.chapter1_3;

/*************************************************************************
 *
 *  Exercise 1.3.31
 *
 *************************************************************************/
public class DoubleLinkedList<Item> {
  private int N;
  private DoubleNode first;
  private DoubleNode last;

  private class DoubleNode {
    Item item;
    DoubleNode next;
    DoubleNode prev;
  }

  public DoubleLinkedList() {
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void append(Item item) {
    DoubleNode node = new DoubleNode();
    node.item = item;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      node.prev = last;
      last.next = node;
      last = node;
    }

    N++;
  }

  public void prepend(Item item) {
    DoubleNode node = new DoubleNode();
    node.item = item;

    if (isEmpty()) {
      first = node;
      last = node;
    } else {
      first.prev = node;
      node.next = first;
      first = node;
    }

    N++;
  }

  public void insertBefore(DoubleNode node, Item item) {
    if (node == first) {
      prepend(item);
    } else {
      DoubleNode x = new DoubleNode();
      x.item = item;

      DoubleNode prev = node.prev;
      prev.next = x;
      x.prev = prev;
      x.next = node;
      node.prev = x;
      N++;
    }
  }

  public void insertAfter(DoubleNode node, Item item) {
    if (node == last) {
      append(item);
    } else {
      DoubleNode x = new DoubleNode();
      x.item = item;
      DoubleNode next = node.next;
      next.prev = x;
      x.next = next;
      x.prev = node;
      node.next = x;
      N++;
    }
  }

  public Item removeFirst() {
    if (isEmpty()) throw new RuntimeException("List is empty");

    Item item = first.item;
    if (first.next != null) {
      first.next.prev = null;
      first = first.next;
    } else {
      first = null;
    }
    N--;

    return item;
  }

  public Item removeLast() {
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

  public Item remove(DoubleNode node) {
    if (node == first) {
      return removeFirst();
    } else if (node == last) {
      return removeLast();
    } else {
      Item item = node.item;
      DoubleNode prev = node.prev;
      DoubleNode next = node.prev;

      prev.next = next;
      next.prev = prev;

      N--;
      return item;
    }

  }
}
