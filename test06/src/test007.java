//滑动窗口、双指针与单调队列/栈专题-LeetCode42.接雨水
public class test007 {
    //三次线性扫描
    //每个矩形条上方所能接受的水的高度，是由它左边最高的矩形，和右边最高的矩形决定的
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        if (n == 0)
            return 0;

        int[] left_max = new int[n];
        int[] right_max = new int[n];

        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }

        return ans;
    }
}
