import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//基本数据结构专题-LeetCode295.数据流的中位数
public class test009 {
    //大根堆，小跟堆 （6，7，8，9，10）（5，4，3，2，1）
    private Queue<Integer> small = new PriorityQueue(Collections.reverseOrder()),
            large = new PriorityQueue();

    private boolean even = true; //偶数为true, 奇数为flase
//    /** initialize your data structure here. */
//    public MedianFinder() {
//
//    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}
