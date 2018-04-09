package 刷题.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个结点 {
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

        public ListNode FindKthToTail(ListNode head,int k) {

            List<ListNode> list = new ArrayList<>();
            while (head != null) {
                list.add(head);
                head = head.next;
            }
            if (k > list.size()) {
                return null;
            }
            return list.get(list.size() - k);
        }

}
