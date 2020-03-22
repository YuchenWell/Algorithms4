package chapter3.chpater3_2;

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
    return min(root);
  }

  private Key min(Node x) {
    if (x.left == null) return x.key;
    return min(x.left);
  }

  /**
   * 有序性的相关方法
   * 3.2.3.1 最大值
   **/
  public Key max() {
    return max(root);
  }

  private Key max(Node x) {
    if (x.right == null) return x.key;
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
}
