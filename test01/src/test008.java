//二分法-LeetCode162.寻找峰值
public class test008 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = 1 + l + (r - l) /2;
            if (nums[mid] > nums[mid - 1]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
