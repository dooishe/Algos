package firstSem.lections.IsSimpleNumber;

import java.util.Arrays;

public class Main {
  ////////////////////////////////////// O(корень(n))
  public static void main(String[] args) {
    int n = 4;
    boolean prime1 = true;
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        prime1 = false;
        break;
      }
    }
    System.out.println(prime1);
    ///////////////////////////////////// O((n-a)корень(n))
    int counter1 = 0;
    for (int a = 2; a <= 10000000; a++) {
      boolean prime2 = true;
      for (int i = 2; i <= Math.sqrt(a); i++) {
        if (a % i == 0) {
          prime2 = false;
          break;
        }
      }
      if (prime2)
        counter1++;
    }
    System.out.println(counter1);
    ////////////////////////////////////// O(nloglog(n))
    int counter2 = 0;
    boolean[] massiv = new boolean[10000000];
    Arrays.fill(massiv, true);
    for (int i = 2; i < massiv.length; i++) {
      if (massiv[i] == true) {
        counter2++;
        for (int j = 2 * i; j < massiv.length; j += i) {
          massiv[j] = false;
        }
      }
    }
    System.out.println(counter2);
  }
}