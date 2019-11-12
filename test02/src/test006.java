//链表专题-LeetCode206.反转链表
public class test006 {
//    //迭代
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;
//    }
    //递归,举例 1，2，3，4，5 中 变化顺序为 5，5-4，5-4-3，这样不断往后加
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        //原链表中尾节点，现链表的头节点
        ListNode tail = reverseList(head.next);
        //head的next指针 的 next值指向head
        head.next.next = head;
        //head的next值指为空
        head.next = null;
        return tail;
    }
}
