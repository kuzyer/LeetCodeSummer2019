import java.util.Stack;

//滑动窗口、双指针与单调队列/栈专题-LeetCode32.最长有效括号
public class test005 {
    //两次线性扫描+贪心
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

    /*
        1.用栈维护当前待匹配的左括号的位置。同时用 start 记录一个新的可能合法的子串的起始位置。初始设为 0。
        2.遇到左括号，当前位置进栈。
        3.遇到右括号，如果当前栈不空，则当前栈顶出栈。出栈后，如果栈为空，则更新答案 i - start + 1；否则更新答案 i - st.top()。
        4.遇到右括号且当前栈为空，则当前的 start 开始的子串不再可能为合法子串了，下一个合法子串的起始位置是 i + 1，更新 start = i + 1。
    */
    //栈
//    public int longestValidParentheses(String s) {
//        int n = s.length();
//        Stack<Integer> st = new Stack<>();
//        int start = 0, ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (s.charAt(i) == '(')
//                st.push(i);
//            else {
//                if (!st.isEmpty()) {
//                    st.pop();
//                    if (st.isEmpty()) {
//                        ans = Math.max(ans, i - start + 1);
//                    } else {
//                        ans = Math.max(ans, i - st.peek());
//                    }
//                } else {
//                    start = i + 1;
//                }
//            }
//
//        }
//        return ans;
//    }
}
