import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//基本数据结构专题-LeetCode187.重复的DNA序列
public class test002 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (map.containsKey(str)) {
                count = map.get(str);
                if (count == 1) {
                    res.add(str);
                }
                count++;
            } else {
                count = 1;
            }
            map.put(str, count);
        }
        return res;
    }
}
