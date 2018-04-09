package 刷题.剑指offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并两个排序的链表 {

 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null || list2 == null) {
                return null;
            }

            ListNode head = list1.val < list2.val ? list1 : list2;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    head.next = list1;
                    head = head.next;
                    list1 = list1.next;
                } else {

                    head.next = list2;
                    head = head.next;
                    list2 = list2.next;
                }
            }
            if (list1 != null) {
                head.next = list1;

            }
            if (list2 != null) {
                head.next = list2;
            }
            return ReverseList(head).next;
        }
        public ListNode ReverseList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = new ListNode(head.val);
            while (head != null && head.next != null) {
                ListNode a = new ListNode(head.next.val);
                a.next = temp;
                temp = a;
                head = head.next;
            }
            return temp;
        }
    }
}
