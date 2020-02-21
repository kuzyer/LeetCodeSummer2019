import java.util.ArrayDeque;
import java.util.Deque;

//滑动窗口、双指针与单调队列/栈专题-LeetCode918.环形子数组的最大和
public class test010 {
    //单调队列
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int[] S = new int[2 * n + 1];
        for (int i = 0; i < n * 2; i++) {
            S[i + 1] = S[i] + A[i % n];
        }

        int res = Integer.MIN_VALUE;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 1; i <= n * 2; i++) {
            if (!q.isEmpty() && i - n > q.peek()) {
                q.poll();
            }
            res = Math.max(res, S[i] - S[q.peek()]);
            while (!q.isEmpty() && S[i] <= S[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);
        }
        return res;
    }
}
