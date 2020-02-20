import java.util.Stack;

//滑动窗口、双指针与单调队列/栈专题-LeetCode155.最小栈
public class test006 {
    private Stack<Integer> data;
    private Stack<Integer> minValue;

    /** initialize your data structure here. */
//    public MinStack() {
//        data = new Stack<>();
//        minValue = new Stack<>();
//    }

    public void push(int x) {
        data.push(x);
        if (minValue.isEmpty() || x <= minValue.peek()) {
            minValue.push(x);
        }
    }

    public void pop() {
        int value = data.pop();
        if (value == minValue.peek()) {
            minValue.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
