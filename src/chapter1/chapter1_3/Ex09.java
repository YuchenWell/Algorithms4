package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Ex09 {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<String> vals = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (s.equals("(")) ;
      else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
        ops.push(s);
      } else if (s.equals(")")) {
        String op = ops.pop();
        String val = vals.pop();
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
          val = String.format("( %s %s %s )", vals.pop(), op, val);
        } else if (op.equals("sqrt")) {
          val = String.format("( sqrt ( %s ) )", val);
        }
        vals.push(val);
      } else {
        vals.push(s);
      }
    }

    StdOut.print(vals.pop());
  }
}
