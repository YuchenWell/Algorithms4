package chapter1.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************
 *  Exercise 1.3.10
 *
 *  % java InfixToPostfix
 *  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 *  1 2 3 + 4 5 * * +
 *
 *  % java InfixToPostfix
 *  ( sqrt ( 1 + 2 ) )
 *  1 2 + sqrt
 *
 *************************************************************************/

public class InfixToPostFix {
  public static void main(String[] args) {
    Stack<String> ops = new Stack<String>();
    Stack<String> vals = new Stack<String>();

    while (!StdIn.isEmpty()) {
      String s = StdIn.readString();

      if (s.equals("(")) ;
      else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
        ops.push(s);
      } else if (s.equals(")")) {
        String val = vals.pop();
        String op = ops.pop();
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
          val = String.format("%s %s %s ", vals.pop(), val, op);
        } else if (op.equals("sqrt")) {
          val = String.format("%s sqrt", val);
        }
        vals.push(val);
      } else {
        vals.push(s);
      }
    }

    StdOut.print(vals.pop());
  }
}
