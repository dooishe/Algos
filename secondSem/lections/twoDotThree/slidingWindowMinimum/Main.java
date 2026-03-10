package secondSem.lections.twoDotThree.slidingWindowMinimum;

import java.util.TreeMap;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    minOnSectionsWithMultiMap(new int[] { 1, 1, 2, 3, 8, -4, 2 }, 3);
    System.out.print('\n');
    minOnSectionsWithQueueMin(new int[] { 1, 1, 2, 3, 8, -4, 2 }, 3);
  }

  public static void minOnSectionsWithMultiMap(int[] values, int k) {
    /*
     * реализация через очередь сложность T = O(nk)
     * через MultiMap (тот же TreeSet, но хранит дубликаты) T = O(nlogk)
     * через QueueMin - очередь минимумов T = O(n)
     */

    MultiMap<Integer> kRangeOfvalues = new MultiMap<>();
    for (int i = 0; i < k - 1; i++)
      kRangeOfvalues.add(values[i]);
    for (int i = k - 1; i < values.length; i++) {
      kRangeOfvalues.add(values[i]);
      System.out.print(kRangeOfvalues.firstKey());
      kRangeOfvalues.remove(values[i - k + 1]);
    }
  }

  static class MultiMap<T> {
    private TreeMap<T, Integer> values = new TreeMap<>();

    public void add(T value) {
      Integer count = values.get(value);
      if (count == null)
        count = 0;
      count++;
      values.put(value, count);
    }

    public void remove(T value) {
      Integer count = values.get(value);
      if (count == null)
        return;
      count--;
      if (count > 0)
        values.put(value, count);
      else
        values.remove(value);
    }

    public T firstKey() {
      return values.firstKey();
    }
  }

  public static void minOnSectionsWithQueueMin(int[] values, int k) {
    QueueMin kRangeOfvalues = new QueueMin();
    for (int i = 0; i < k - 1; i++)
      kRangeOfvalues.add(values[i]);
    for (int i = k - 1; i < values.length; i++) {
      kRangeOfvalues.add(values[i]);
      System.out.print(kRangeOfvalues.getMin());
      kRangeOfvalues.pop();
    }
  }

  static class QueueMin {
    private StackMin in = new StackMin();
    private StackMin out = new StackMin();

    public void add(int x) {
      in.add(x);
    }

    public void pop() {
      if (out.isEmpty()) {
        while (!in.isEmpty()) {
          int result = in.top();
          in.pop();
          out.add(result);
        }
      }
      out.pop();
    }

    public int getMin() {
      if (out.isEmpty()) {
        return in.getMin();
      } else if (in.isEmpty()) {
        return out.getMin();
      } else {
        return Math.min(in.getMin(), out.getMin());
      }
    }
  }

  static class StackMin {
    private Stack<Integer> values = new Stack<>();
    private Stack<Integer> minValues = new Stack<>();

    public void add(int x) {
      values.push(x);
      int minV = minValues.isEmpty() ? x : Math.min(x, minValues.peek());
      minValues.push(minV);
    }

    public void pop() {
      values.pop();
      minValues.pop();
    }

    public int top() {
      return values.peek();
    }

    public int getMin() {
      return minValues.peek();
    }

    public boolean isEmpty() {
      return values.isEmpty();
    }
  }

}
