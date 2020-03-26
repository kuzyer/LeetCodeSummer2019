//字符串处理专题-LeetCode5.最长回文子串
public class test006 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); //单核回文（子串长度为奇数）
            int len2 = expandAroundCenter(s, i , i + 1); //双核回文（子串长度为偶数）
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2; //如果子串长度为偶数，那么中心左边的长度会比右边的长度小1
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //从中心向两边扩散
    public int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        //去掉之前的多操作的（L-- R++）
        return R - L - 1;
    }
}
