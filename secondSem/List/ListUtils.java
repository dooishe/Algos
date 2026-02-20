package secondSem.List;

public class ListUtils {
  public static class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static ListNode copyList(ListNode A) {
    if (A == null)
      return null;

    ListNode B = new ListNode(A.val);
    A = A.next;
    ListNode curr = B;
    while (A != null) {
      curr.next = new ListNode(A.val);
      curr = curr.next;
      A = A.next;
    }
    return B;
  }

  public static int lPalin(ListNode A) {
    ListNode B = copyList(A);
    B = reverseList(B);
    ListNode currA = A;
    ListNode currB = B;
    while (currA != null && currB != null) {
      if (currA.val != currB.val) {
        return 0;
      }
      currA = currA.next;
      currB = currB.next;
    }

    return 1;
  }

  /* сложность O(n), память O(1) */
  public static ListNode reverseList(ListNode A) {
    ListNode curr = A;
    ListNode next = curr.next;
    ListNode prev = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
}