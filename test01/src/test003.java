//二分法-LeetCode35.在排序数组中查找元素的第一个和最后一个位置
public class test003 {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        if (nums == null || nums.length == 0) return targetRange;

        int l = 0, r = nums.length - 1;
        //找最接近mid的右边界
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[r] != target) {
            return targetRange;
        }

        targetRange[0] = r;

        l = 0;
        r = nums.length - 1;
        //找最接近mid的左边界
        while (l < r) {
            int mid = 1 + l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        targetRange[1] = l;

        return targetRange;
    }
}
