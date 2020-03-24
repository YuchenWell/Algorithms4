package chapter3.chpater3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value val;
    private Node left;
    private Node right;
    private int N;

    public Node(Key key, Value val, int N) {
      this.key = key;
      this.val = val;
      this.N = N;
    }
  }

  public int size() {
    return size(root);
  }

  public int size(Node x) {
    if (x == null) return 0;
    return x.N;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x.val;
    } else if (cmp < 0) {
      return get(x.left, key);
    } else {
      return get(x.right, key);
    }
  }

  public void put(Key key, Value val) {
    root = put(root, key, val);
  }

  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val, 1);

    int cmp = key.compareTo(x.key);

    if (cmp < 0) {
      x.left = put(x.left, key, val);
    } else if (cmp > 0) {
      x.right = put(x.right, key, val);
    } else {
      x.val = val;
    }

    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * 有序性的相关方法
   * 3.2.3.1 最小值
   **/
  public Key min() {
    return min(root).key;
  }

  private Node min(Node x) {
    if (x.left == null) return x;
    return min(x.left);
  }

  /**
   * 有序性的相关方法
   * 3.2.3.1 最大值
   **/
  public Key max() {
    return max(root).key;
  }

  private Node max(Node x) {
    if (x.right == null) return x;
    return max(x.right);
  }

  /**
   * 有序性的相关方法
   * 3.2.3.2 向下取整
   **/
  public Key floor(Key key) {
    Node x = floor(root, key);
    if (x == null) return null;
    return x.key;
  }

  private Node floor(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    } else if (cmp < 0) {
      return floor(x.left, key);
    } else {
      Node t = floor(x.right, key);
      if (t != null) return t;
      return x;
    }
  }

  /**
   * 有序性的相关方法
   * 3.2.3.2 向上取整
   **/
  public Key ceiling(Key key) {
    Node x = ceiling(root, key);
    if (x == null) return null;
    return x.key;
  }

  private Node ceiling(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);
    if (cmp == 0) {
      return x;
    } else if (cmp > 0) {
      return ceiling(x.right, key);
    } else {
      Node t = ceiling(x.left, key);
      if (t != null) return t;
      return x;
    }
  }

  /**
   * 有序性的相关方法
   * 3.2.3.3 选择操作
   **/
  public Key select(int k) {
    return select(root, k).key;
  }

  private Node select(Node x, int k) {
    if (x == null) return null;

    int t = size(x.left);
    if (t > k) {
      return select(x.left, k);
    } else if (t < k) {
      return select(x.right, k - t - 1);
    } else {
      return x;
    }
  }

  /**
   * 有序性的相关方法
   * 3.2.3.4 排名
   **/
  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node x, Key key) {
    if (x == null) return 0;

    int cmp = key.compareTo(x.key);
    if (cmp > 0) {
      return size(x.left) + 1 + rank(x.right, key);
    } else if (cmp < 0) {
      return rank(x.left, key);
    } else {
      return size(x.left);
    }
  }

  /**
   * 有序性的相关方法
   * 3.2.3.5 删除最小值
   **/
  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node x) {
    if (x.left == null) return x.right;
    x.left = deleteMin(x.left);
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * 有序性的相关方法
   * 3.2.3.5 删除最大值
   **/
  public void deleteMax() {
    root = deleteMax(root);
  }

  private Node deleteMax(Node x) {
    if (x.right == null) return x.left;
    x.right = deleteMax(x.right);
    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * 有序性的相关方法
   * 3.2.3.6 ** 删除操作 **
   **/
  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) {
      return delete(x.left, key);
    } else if (cmp > 0) {
      return delete(x.right, key);
    } else {
      if (x.right == null) return x.left;
      if (x.left == null) return x.right;

      Node t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }

    x.N = size(x.left) + size(x.right) + 1;
    return x;
  }

  /**
   * 有序性的相关方法
   * 3.2.3.7 按顺序打印二叉树中的所有键
   **/
  public void print(Node x) {
    if (x == null) return;
    print(x.left);
    StdOut.println(x.key);
    print(x.right);
  }

  /**
   * 有序性的相关方法
   * 3.2.3.7 中序遍历
   **/
  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key min, Key max) {
    Queue<Key> queue = new Queue<Key>();
    keys(root, queue, min, max);
    return queue;
  }

  public void keys(Node x, Queue<Key> queue, Key min, Key max) {
    if (x == null) return;

    int cmpMin = min.compareTo(x.key);
    int cmpMax = max.compareTo(x.key);

    if (cmpMin < 0) keys(x.left, queue, min, max);
    if (cmpMin <= 0 && cmpMax >= 0) queue.enqueue(x.key);
    if (cmpMax > 0) keys(x.right, queue, min, max);
  }
}
