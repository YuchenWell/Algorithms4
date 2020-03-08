package chapter3.chpater3_1;

import edu.princeton.cs.algs4.StdOut;

public class SequentialSearchST<Key, Value> {
  private Node first;

  private class Node {
    Key key;
    Value val;
    Node next;

    public Node(Key key, Value val, Node next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  public Value get(Key key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.val;
      }
    }

    return null;
  }

  public void put(Key key, Value val) {
    if (val == null) {
      delete(key);
    }

    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.val = val;
        return;
      }
    }

    first = new Node(key, val, first);
  }

  public Value delete(Key key) {
    if (key.equals(first.key)) {
      Value val = first.val;
      first = first.next;
      return val;
    }

    for (Node prev = first; prev.next != null; prev = prev.next) {
      if (key.equals(prev.next.key)) {
        Value val = prev.next.val;
        prev.next = prev.next.next;
        return val;
      }
    }

    return null;
  }

  public int size() {
    int i = 0;
    for (Node x = first; x != null; x = x.next) {
      i++;
    }
    return i;
  }

  public boolean contain(Key key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return true;
      }
    }

    return false;
  }

  private void show() {
    for (Node x = first; x != null; x = x.next) {
      StdOut.println(x.key + ": " + x.val);
    }
  }

  public static void main(String[] args) {
    String str = "SEARCHEXAMPLE";
    String[] strArray = str.split("");
    SequentialSearchST<String, Integer> st = new SequentialSearchST<>();

    for (int i = 0; i < strArray.length; i++) {
      st.put(strArray[i], i);
    }

    st.show();
  }

}
