package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
  private Item[] bag = (Item[]) new Object[1];
  private int N = 0;

  public int size() {
    return N;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  private void resize(int max) {
    Item[] temp = (Item[]) new Object[max];

    for (int i = 0; i < N; i++) {
      temp[i] = bag[i];
    }
    bag = temp;
  }

  private void add(Item item) {
    if (N == bag.length) resize(N * 2);

    bag[N++] = item;
  }

  public Iterator<Item> iterator() {
    return new RandomBagIterator();
  }

  private class RandomBagIterator implements Iterator<Item> {
    private int n = N;

    public RandomBagIterator() {
      // ** Fisher–Yates shuffle 洗牌算法 **
      StdRandom.shuffle(bag);
    }

    public boolean hasNext() {
      return N > 0;
    }

    public void remove() {

    }

    public Item next() {
      return bag[--N];
    }
  }

  public static void main(String[] args) {
    RandomBag<String> randomBag = new RandomBag<String>();

    randomBag.add("A");
    randomBag.add("B");
    randomBag.add("C");
    randomBag.add("D");

    for (String string : randomBag) {
      StdOut.print(string);
    }
  }

}
