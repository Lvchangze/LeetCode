package LinkedList;

public class P2 {
    //将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补0
    //每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
    //如果两个链表全部遍历完毕后，进位值为 1，则在新链表最前方添加节点 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
