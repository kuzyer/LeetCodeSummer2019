//字符串处理专题-LeetCode165.比较版本号
public class test004 {
    public int compareVersion(String version1, String version2) {
        //java里面以. \ |为分隔符时，需要加上\，即\. \\ \|才能正确分割
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int len = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < len; i++) {
            int v1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int v2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        return 0;
    }
}
