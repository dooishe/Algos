package secondSem.lections.twoDotThree.bracketSequence;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) {
    System.out.println(bracketSequence("}}{{")); // ожидаем false
    System.out.println(bracketSequence("{}{}")); // true
    System.out.println(bracketSequence("{[()]}")); // true
    System.out.println(bracketSequence("([)]")); // false
  }

  public static boolean bracketSequence(String str) {
    // T = O(n) M = O(n)
    final Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else if (c == '}' || c == ']' || c == ')') {
        if (stack.isEmpty())
          return false;
        char lastElement = stack.peek();
        if (c == '}' && lastElement == '{' ||
            c == ']' && lastElement == '[' ||
            c == ')' && lastElement == '(') {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}