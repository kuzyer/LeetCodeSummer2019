//二分法-LeetCode278.第一个错误的版本
public class test007 {
    public static int[] a = {0,1,1,1,2,2};

    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
//            if (isBadVersion(mid)) {
            if (a[mid] == 2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

//    public int firstBadVersion(int n) {
//        int l = 1, r = n;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (isBadVersion(mid)) {
//                r = mid;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
