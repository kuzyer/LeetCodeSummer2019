//动态规划专题-LeetCode300.最长上升子序列
public class test006 {
    //时间复杂度O(n^2)
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        if (n == 0)
//            return n;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//        }
//        int res = 1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            if (dp[i] > res) {
//                res = dp[i];
//            }
//        }
//        return res;
//    }

    /*
        时间复杂度O(nlogn)
        https://www.acwing.com/solution/LeetCode/content/287/
        维护一个新的数组help，help[i]表示最长子序列长度为i时的最小的结尾num值
        （例如在数组[1,2,5,3,7]中，长度为3的子序列有[1,2,3]，[1,2,5]，[2,5,7]三个，取最小的结尾数字，那么help[3]=3）
        help[i]是个单调数组，因此使用二分查找提高查找效率
    */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return n;

        int[] help = new int[n + 1];
        help[1] = nums[0];
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            int left = 1;
            int right = maxLen;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (help[mid] < nums[i])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            help[left] = nums[i]; //维护help数组
            if (left > maxLen) //left值是nums[i]的子序列长度
                maxLen = left;
        }

        return maxLen;
    }
}
