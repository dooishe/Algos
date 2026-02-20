package secondSem.List.onTheLessons.ReverseLinkedList;

import static secondSem.List.ListUtils.ListNode;
import secondSem.List.ListUtils;

public class Main {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode curr = head;
    curr.next = new ListNode(2);
    curr = curr.next;
    curr.next = new ListNode(3);
    curr = curr.next;
    curr.next = new ListNode(4);
    curr = curr.next;
    curr.next = new ListNode(5);
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.err.println("\n");
    head = ListUtils.reverseList(head);
    node = head;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }
}
