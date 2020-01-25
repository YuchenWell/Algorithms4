package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {
  private String[] a;
  private int N;

  public FixedCapacityStackOfStrings(int cap) {
    a = new String[cap];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void push(String item) {
    a[N++] = item;
  }

  public String pop() {
    return a[--N];
  }


  /**
   * Ex1.3.1
   */
  public boolean isFull() {
    return N == a.length;
  }

  public static void main(String[] args) {
    FixedCapacityStackOfStrings s;
    s = new FixedCapacityStackOfStrings(100);

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


