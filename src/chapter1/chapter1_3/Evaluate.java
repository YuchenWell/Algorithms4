package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<Double> vals = new Stack<Double>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();
      if (s.equals("(")) ;
      else if (s.equals("+")) ops.push(s);
      else if (s.equals("-")) ops.push(s);
      else if (s.equals("*")) ops.push(s);
      else if (s.equals("/")) ops.push(s);
      else if (s.equals("sqrt")) ops.push(s);
      else if (s.equals(")")) {
        String op = ops.pop();
        double val = vals.pop();
        if (op.equals("+")) vals.push(vals.pop() + val);
        else if (op.equals("-")) vals.push(vals.pop() - val);
        else if (op.equals("*")) vals.push(vals.pop() * val);
        else if (op.equals("/")) vals.push(vals.pop() / val);
        else if (op.equals("sqrt")) vals.push(val * val);
      } else {
        vals.push(Double.parseDouble(s));
      }
    }

    StdOut.println(vals.pop());
  }
}
