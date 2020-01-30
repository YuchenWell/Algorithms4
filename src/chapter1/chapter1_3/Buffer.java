package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *  Exercise 1.3.44
 *  文本编辑器的缓冲区的数据结构 Buffer
 *************************************************************************/

public class Buffer {
  Stack<Character> left = new Stack<Character>();
  Stack<Character> right = new Stack<Character>();

  public void insert(char c) {
    left.push(c);
  }

  public char delete() {
    return left.pop();
  }

  public void left(int k) {
    if (left.size() < k) return;

    for (int i = 1; i <= k; i++) {
      right.push(left.pop());
    }
  }

  public void right(int k) {
    if (right.size() < k) return;

    for (int i = 1; i <= k; i++) {
      left.push(right.pop());
    }

  }

  public int size() {
    return left.size() + left.size();
  }

  private void print() {
    StdOut.print("Left: ");
    for (char c : left) {
      StdOut.print(c);
    }

    StdOut.print(", Right: ");
    for (char c : right) {
      StdOut.print(c);
    }
  }

  public static void main(String[] args) {
    Buffer buffer = new Buffer();

    buffer.insert('A');
    buffer.insert('B');
    buffer.insert('C');
    buffer.insert('D');
    buffer.insert('E');
    buffer.insert('F');

    StdOut.print("Original => ");
    buffer.print();

    buffer.left(3);
    StdOut.println();
    StdOut.print("left *3 => ");
    buffer.print();

    buffer.delete();
    buffer.delete();
    StdOut.println();
    StdOut.print("delete *2 => ");
    buffer.print();

    buffer.insert('G');
    buffer.insert('H');
    StdOut.println();
    StdOut.print("insert *2 => ");
    buffer.print();

    buffer.right(2);
    StdOut.println();
    StdOut.print("right *2 => ");
    buffer.print();
  }
}
