package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
  private Item[] a = (Item[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(Item item) {
    if (N == a.length) resize(N * 2);
    a[N++] = item;
  }

  public Item pop() {
    Item item = a[--N];
    a[N] = null;
    if (N > 0 && N == a.length / 4) resize(N / 2);
    return item;
  }

  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<Item> {
    private int i = N;

    public boolean hasNext() {
      return i > 0;
    }

    public Item next() {
      return a[--i];
    }

    public void remove() {
    }
  }

  public static void main(String[] args) {
    ResizingArrayStack<String> s;
    s = new ResizingArrayStack<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-")) {
        s.push(item);
      } else {
        s.pop();
      }


      for (String str : s) {
        StdOut.print(str);
      }

      StdOut.println("(" + s.size() + " left on stack)");
    }
  }
}
