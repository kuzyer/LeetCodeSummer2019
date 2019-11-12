//链表专题-LeetCode148.排序链表
public class test010 {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode p = head; p != null; p = p.next) {
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int i = 1; i < n; i *= 2) {
            ListNode begin = dummy;
            for (int j = 0; j + i < n; j += i * 2) {
                ListNode first = begin.next, second = begin.next;
                for (int k = 0; k < i; k++) {
                    second = second.next;
                }
                //二路归并第一段, 第二段;
                int f = 0, s = 0;
                while (f < i && s < i && second != null) {
                    if (first.val < second.val) {
                        begin.next = first;
                        begin = first;
                        first = first.next;
                        f++;
                    } else {
                        begin.next = second;
                        begin = second;
                        second = second.next;
                        s++;
                    }
                }

                while (f < i) {
                    begin.next = first;
                    begin = first;
                    first = first.next;
                    f++;
                }

                while (s < i && second != null) {
                    begin.next = second;
                    begin = second;
                    second = second.next;
                    s++;
                }
                begin.next = second;
            }
        }
        return dummy.next;
    }
}
