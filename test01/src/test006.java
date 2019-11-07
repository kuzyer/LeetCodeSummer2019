//二分法-LeetCode33.搜索旋转排序数组
public class test006 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        //排除数组单调情况
        if (nums[r] < nums[0]) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] < nums[0]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            //判断目标值在哪一端
            if (target <=  nums[nums.length - 1]) {
                r = nums.length - 1;
            } else {
                l = 0; r--;
            }
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[l] == target) {
            return l;
        } else {
            return -1;
        }
    }
}
