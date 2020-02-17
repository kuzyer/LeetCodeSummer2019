//滑动窗口、双指针与单调队列/栈专题-LeetCode167.两数之和II-输入有序数组
public class test001 {
    //每次将i后移一位，然后不断前移j，直到numbers[j] + numbers[i] <= target为止
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0, j = numbers.length - 1; i < j; i++) {
            while (numbers[j] + numbers[i] > target) j--;
            if (numbers[j] + numbers[i] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
        }
        return result;
    }
}
