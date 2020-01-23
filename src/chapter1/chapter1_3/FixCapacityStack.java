package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixCapacityStack<Item> {
  private Item[] stack;
  private int N;

  public FixCapacityStack(int cap) {
    stack = (Item[]) new Object[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(Item item) {
    stack[N++] = item;
  }

  public Item pop() {
    return stack[--N];
  }

  public static void main(String[] args) {
    FixCapacityStack<String> s;
    s = new FixCapacityStack<String>(100);


    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if (!item.equals("-")) {
        s.push(item);
      } else {
        s.pop();
      }
      StdOut.println("(" + s.size() + " left on stack)");
    }
  }
}
