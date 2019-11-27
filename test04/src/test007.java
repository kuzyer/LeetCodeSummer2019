//字符串处理专题-LeetCode6.Z字形变换
public class test007 {
    public String convert(String s, int numRows) {
        /*
        第0行，首项为0，公差为2n - 2
        第n-1行，首项为0，公差为2n - 2
        第i行，两个公差为2n - 2的等差数列交替排列，首项分别是i和2n - i - 2
        */
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(i + j));
                //判断是否为中间的行
                if (i != 0 && i != numRows - 1 && cycleLen - i + j < n) {
                    ret.append(s.charAt(cycleLen - i + j));
                }
            }
        }
        return ret.toString();
    }
}
