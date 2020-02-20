//滑动窗口、双指针与单调队列/栈专题-LeetCode32.最长有效括号
public class test005 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int start = 0, val = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                val++;
            else
                val--;
            if (val < 0) {
                val = 0;
                start = i + 1;
            } else if (val == 0) {
                ans = Math.max(ans, i - start + 1);
            }
        }
        start = n - 1; val = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')')
                val++;
            else
                val--;
            if (val < 0) {
                val = 0;
                start = i - 1;
            } else if (val == 0) {
                ans = Math.max(ans, start - i + 1);
            }
        }
        return ans;
    }
}
