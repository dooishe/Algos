package IsSimpleNumber;

public class Main {
  public static void main(String[] args) {
    int s = 4;
    boolean prime1 = true;
    for (int i = 2; i <= Math.sqrt(s); i++) {
      if(s % i == 0) {
        prime1 = false;
        break;
      }
    }
    System.out.println(prime1);
    /////////////////////////////////////
    int counter = 0;
    for (int m = 2; m <= 7; m++) {
      boolean prime2 = true;
      for (int i = 2; i <= Math.sqrt(m); i++) {
      if(m % i == 0) {
        prime2 = false;
        break;
      }
    }
    if(prime2) counter++;
    }
    System.out.println(counter);
  }
}