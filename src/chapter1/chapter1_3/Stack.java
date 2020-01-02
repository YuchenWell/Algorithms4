package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void resize(int max) {
    Item[] temp = (Item[]) new Object[max];

    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (N == a.length) resize(a.length * 2);
    a[N++] = item;
  }

  public Item pop() {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length / 4) resize(a.length * 2);
    return item;
  }


  public static void main(String[] args) {
    Stack<String> s = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      StdOut.print(item + " ");
      if (!item.contains("-")) {
        s.push(item);
      } else if (!s.isEmpty()) {
        StdOut.print(s.pop() + " ");
      }
      StdOut.println("(" + s.size() + " left on stack)");
    }

  }
}
