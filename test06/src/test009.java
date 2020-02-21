import java.util.ArrayDeque;
import java.util.Deque;

//滑动窗口、双指针与单调队列/栈专题-LeetCode239.滑动窗口最大值
public class test009 {
    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int count = 0;
        for (int i = 0; i < n; i++) {

            while (!q.isEmpty() && i - q.peek() >= k) {
                q.poll();
            }

            while (!q.isEmpty() && nums[i] >= nums[q.peekLast()]) {
                q.pollLast();
            }

            q.offer(i);

            if (i >= k - 1) {
                ans[count++] = nums[q.peek()];
            }
        }
        return ans;
    }
}
