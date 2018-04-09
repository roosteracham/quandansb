package 刷题.剑指offer;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class 反转链表 {
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
