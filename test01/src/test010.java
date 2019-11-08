//二分法-LeetCode275.H指数II
public class test010 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int l = 0, r = citations.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations.length - mid <= citations[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (citations.length - l <= citations[l]) return citations.length - l;
        return 0;
    }
}
