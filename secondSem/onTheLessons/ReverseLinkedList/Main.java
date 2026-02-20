package secondSem.onTheLessons.ReverseLinkedList;

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
    head = reverseList(head);
    node = head;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  static class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
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
