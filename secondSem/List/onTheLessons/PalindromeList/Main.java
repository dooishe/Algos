package secondSem.List.onTheLessons.PalindromeList;

import static secondSem.List.ListUtils.ListNode;
import secondSem.List.ListUtils;

public class Main {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode curr = head;
    curr.next = new ListNode(3);
    curr = curr.next;
    curr.next = new ListNode(2);
    curr = curr.next;
    curr.next = new ListNode(2);
    curr = curr.next;
    curr.next = new ListNode(3);
    curr = curr.next;
    curr.next = new ListNode(1);

    System.out.println(ListUtils.lPalin(head));
  }
}
