package 刷题.剑指offer;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {

    public class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

            ListNode p1 = pHead1, p2 = pHead2;
            while (p1 != p2) {
                p1 = (p1 == null) ? pHead2 : p1.next;
                p2 = (p2 == null) ? pHead1 : p2.next;
            }
            return p1 == null ? p2 : p1;
        }
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}