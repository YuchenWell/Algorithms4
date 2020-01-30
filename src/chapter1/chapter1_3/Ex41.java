package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 * Ex 1.3.41
 * 复制队列
 *************************************************************************/

public class Ex41 {
  public static void main(String[] args) {
    Queue<String> queue1 = new Queue<String>();

    queue1.enqueue("A");
    queue1.enqueue("B");
    queue1.enqueue("C");
    queue1.enqueue("D");

    StdOut.print("Queue 1 (Original): ");
    for (String string : queue1) {
      StdOut.print(string);
    }

    Queue<String> queue2 = new Queue<String>(queue1);

    StdOut.println("");
    StdOut.print("Queue 2 (copied queue1): ");
    for (String string : queue2) {
      StdOut.print(string);
    }

    queue1.dequeue();
    queue1.dequeue();

    StdOut.println("");
    StdOut.print("Queue 1 (queue 1 dequeue *2): ");
    for (String string : queue1) {
      StdOut.print(string);
    }

    StdOut.println("");
    StdOut.print("Queue 2 (queue 1 dequeue *2): ");
    for (String string : queue2) {
      StdOut.print(string);
    }

    queue2.dequeue();

    StdOut.println("");
    StdOut.print("Queue 1 (queue 2 dequeue *1): ");
    for (String string : queue1) {
      StdOut.print(string);
    }

    StdOut.println("");
    StdOut.print("Queue 2 (queue 2 dequeue *1): ");
    for (String string : queue2) {
      StdOut.print(string);
    }
  }
}
