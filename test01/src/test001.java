//二分法-LeetCode69.x的平方根
public class test001 {
    public int mySqrt(int x) {
        if (x == 0) return x;
        int left = 0, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid;
            } else if (mid + 1 > x / (mid + 1)) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
    }
}
