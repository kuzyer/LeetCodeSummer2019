//链表专题-LeetCode92.反转链表II
public class test007 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode a = p, b = a.next, c = b.next;
        //由于去除了m = n的情况，此时必然 m < n
        for (int i = m + 1; i <= n; i++) {
            ListNode d = c.next;
            c.next = b;
            b = c;
            c = d;
        }
        //a.next结点的next值设为c
        a.next.next = c;
        //a结点的next值设为b
        a.next = b;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode s = reverseBetween(a, 2, 4);
        while(s != null) {
            System.out.println(s.val);
            s = s.next;
        }

    }
}
