import java.util.HashMap;
//链表专题-LeetCode142.环形链表II
public class test009 {
//    //哈希表法
//    public ListNode detectCycle(ListNode head) {
//        HashMap<ListNode, Integer> map = new HashMap<>();
//        ListNode p = head;
//        while (p != null) {
//            if (map.containsKey(p)) {
//                return p;
//            } else {
//                map.put(p, p.val);
//            }
//            p = p.next;
//        }
//        return null;
//    }

    //快慢指针扫描
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode first = head, second = head;
        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            } else {
                return null;
            }

            if (first == second) {
                first = head;
                while (first != second) {
                    first = first.next;
                    second = second.next;
                }
                return first;
            }
        }
        return null;
    }
}
