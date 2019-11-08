//链表专题-LeetCode19.删除链表的倒数第N个节点
public class test001 {
//    //两次遍历
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int length = 0;
//        ListNode first = head;
//        while (first != null) {
//            length++;
//            first = first.next;
//        }
//        length = length - n;
//        first = dummy;
//        while (length > 0) {
//            length--;
//            first = first.next;
//        }
//        first.next = first.next.next;
//        return dummy.next;
//    }

    //一次遍历
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        //first到头时，second的目标位置也找到了
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }


}
