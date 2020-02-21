import java.util.Stack;

//滑动窗口、双指针与单调队列/栈专题-LeetCode84.柱状图中最大的矩形
public class test008 {
    /*
    1.此题的本质是找到每个柱形条左边和右边最近的比自己低的矩形条，然后用宽度乘上当前柱形条的高度作为备选答案。
    2.解决此类问题的经典做法是单调栈，维护一个单调递增的栈，如果当前柱形条i的高度比栈顶要低，则栈顶元素cur出栈。出栈后，
    cur右边第一个比它低的柱形条就是i，左边第一个比它低的柱形条是当前栈中的top。不断出栈直到栈为空或者柱形条i不再比top低。
    3.满足2之后，当前矩形条i进栈。
*/
    //单调栈
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        // 为了算法书写方便，在数组末尾添加高度 -1
        // 这会使得栈中所有数字在最后出栈。
        int[] new_heights = new int[n + 1];
        for (int i = 0; i < n; i++) {
            new_heights[i] = heights[i];
        }
        new_heights[n] = -1;

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && new_heights[i] < new_heights[st.peek()]) {
                int cur = st.peek();
                st.pop();
                if (st.isEmpty()) {
                    ans = Math.max(ans, new_heights[cur] * i);
                } else {
                    ans = Math.max(ans, new_heights[cur] * (i - st.peek() - 1));
                }
            }
            st.push(i);
        }

        return ans;
    }
}
