import java.util.HashMap;

//基本数据结构专题-LeetCode560.和为K的子数组
public class test005 {
    /*
    给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
    示例:
    输入:nums = [1,1,1], k = 2
    输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    注意，问题要求是连续的，所以输出的意思为 结果1:a[0],a[1]; 结果2:a[1],a[2]
*/
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sum = 0, ans = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                ans += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
