package LinkedList;

public class P19 {
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode(-1);//哨兵结点
        pre.next = head;
        ListNode result = pre;
        while (n > 0){
            fast = fast.next;
            n--;
        }
        while (fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return result.next;
    }
}
