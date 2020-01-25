package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

/**
 * 反转Queue
 */
public class Ex06 {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<String>();
    Queue<String> queue = new Queue<String>();

    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");

    for (String item : queue) {
      StdOut.print(item);
    }
    StdOut.println();

    while (!queue.isEmpty()) {
      stack.push(queue.dequeue());
    }
    while (!stack.isEmpty()) {
      queue.enqueue(stack.pop());
    }

    for (String item : queue) {
      StdOut.print(item);
    }

  }


}
