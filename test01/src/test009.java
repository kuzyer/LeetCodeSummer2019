//二分法-LeetCode287.寻找重复数
public class test009 {
    public static int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= l && nums[i] <= mid) {
                    cnt++;
                }
            }
            //判断处于哪个范围圈中，找到目标
            if (cnt > mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
