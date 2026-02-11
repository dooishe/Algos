package IsSimpleNumber;

public class Main {
  public static void main(String[] args) {
    int s = 4;
    boolean prime = true;
    for (int i = 2; i <= Math.sqrt(s); i++) {
      if(s % i == 0) {
        prime = false;
        break;
      }
    }
    System.out.println(prime);
  }
}