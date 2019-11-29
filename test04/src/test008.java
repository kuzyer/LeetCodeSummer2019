import java.util.HashMap;

//字符串处理专题-LeetCode3.无重复字符的最长子串
public class test008 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //之所以加一是因为左侧应从原有的字母后面开始算起
                //之所以使用max，是为了保证j不会退回到记录之外的位置，
                //例子“abba”, 若进入到s[3],j = 1, i = 3,得到 3 - 1 + 1 = 3，结果是错误的
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
