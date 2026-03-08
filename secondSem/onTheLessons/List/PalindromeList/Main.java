package secondSem.onTheLessons.List.PalindromeList;

import static secondSem.onTheLessons.List.ListUtils.ListNode;
import secondSem.onTheLessons.List.ListUtils;

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
