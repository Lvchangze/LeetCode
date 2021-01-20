package ByteDance;


import java.util.*;

public class reverseList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        List<Integer> array = new ArrayList<>();
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            array.add(tmp.val);
            length++;
            tmp = tmp.next;
        }
        Collections.reverse(array);
        ListNode result2 = new ListNode(array.get(0));
        ListNode result = result2;
        for (int i = 1; i < length; i++) {
            result2.next = new ListNode(array.get(i));
            result2 = result2.next;
        }
        return result;
    }
}
