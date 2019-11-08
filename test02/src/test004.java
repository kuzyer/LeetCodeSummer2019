//链表专题-LeetCode61.旋转链表
public class test004 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int n = 1;
        ListNode old_tail = head;
        while (old_tail.next != null) {
            n++;
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        //链尾位置为（n - k % n - 1）, 链头位置为（n - k % n）  (开头以0为标准)
        ListNode next_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            next_tail = next_tail.next;
        }
        //设置链头和链尾
        ListNode new_head = next_tail.next;
        next_tail.next = null;

        return new_head;

    }
}
