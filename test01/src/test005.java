//二分法-LeetCode153.寻找旋转排序数组中的最小值
public class test005 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        //排除数组单调情况
        if (nums[r] > nums[0]) return nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
