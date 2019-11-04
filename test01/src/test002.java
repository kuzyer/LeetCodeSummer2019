//二分法-LeetCode35.搜索插入的位置
public class test002 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
