package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/*************************************************************************
 *  Exercise 1.3.35
 *  随机队列
 *
 *  Exercise 1.3.36
 *  随机迭代器
 *  Fisher–Yates shuffle 洗牌算法
 *************************************************************************/

public class RandomQueue<Item> implements Iterable<Item> {
  private Item[] randomQueue = (Item[]) new Object[1];
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
      temp[i] = randomQueue[i];
    }
    randomQueue = temp;
  }


  public void enqueue(Item item) {
    if (N == randomQueue.length) resize(N * 2);
    randomQueue[N++] = item;
  }

  public Item dequeue() {
    if (isEmpty()) return null;

    int random = (int) (Math.random() * N);
    Item item = randomQueue[random];
    randomQueue[random] = randomQueue[N - 1];
    randomQueue[N - 1] = null;
    N--;
    if (N > 0 & N == randomQueue.length / 4) resize(randomQueue.length / 2);
    return item;
  }

  public Item sampLe() {
    if (isEmpty()) return null;
    int random = (int) (Math.random() * N);
    return randomQueue[random];
  }

  public Iterator<Item> iterator() {
    return new RandomQueueIterator();
  }

  private class RandomQueueIterator implements Iterator<Item> {
    private int n = N;

    public RandomQueueIterator() {
      StdRandom.shuffle(randomQueue);
    }

    public boolean hasNext() {
      return n > 0;
    }

    public void remove() {

    }

    public Item next() {
      return randomQueue[--n];
    }
  }


  public static void main(String[] args) {
    RandomQueue<String> randomQueue = new RandomQueue<String>();

    randomQueue.enqueue("A");
    randomQueue.enqueue("B");
    randomQueue.enqueue("C");
    randomQueue.enqueue("D");

    StdOut.println("Iterator: ");
    for (String string : randomQueue) {
      StdOut.print(string);
    }

    StdOut.println();
    StdOut.println("Sample (6x): ");
    StdOut.print(randomQueue.sampLe());
    StdOut.print(randomQueue.sampLe());
    StdOut.print(randomQueue.sampLe());
    StdOut.print(randomQueue.sampLe());
    StdOut.print(randomQueue.sampLe());
    StdOut.print(randomQueue.sampLe());

    StdOut.println();
    StdOut.println("Dequeue (6x): ");
    StdOut.print(randomQueue.dequeue());
    StdOut.print(randomQueue.dequeue());
    StdOut.print(randomQueue.dequeue());
    StdOut.print(randomQueue.dequeue());
    StdOut.print(randomQueue.dequeue());
    StdOut.print(randomQueue.dequeue());
  }
}
