package secondSem.lections.twoDotThree.minOnSections;

import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    minOnSections(new int[] { 1, 1, 2, 3, 8, -4, 2 }, 3);
  }

  public static void minOnSections(int[] values, int k) {
    /*
     * реализация через очередь сложность T = O(nk)
     * через MultiMap (тот же TreeSet, но хранит дубликаты) T = O(nlogk)
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
}
