package LinkedList;

public class P24 {
    public ListNode swapPairs(ListNode head) {
        ListNode nil = new ListNode(-1);
        nil.next = head;
        ListNode ptr = head;
        ListNode pre = nil;
        while (ptr != null  && ptr.next != null) {//至少得有两个节点
            ListNode first = pre.next;
            ListNode second = pre.next.next;
            first.next = second.next;
            second.next = first;
            pre.next = second;
            pre = first;
            ptr = ptr.next;
        }
        return nil.next;
    }
}
