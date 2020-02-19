import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//滑动窗口、双指针与单调队列/栈专题-LeetCode76.最小覆盖子串
public class test004 {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // 将t中各个字符的频数进行统计
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // t中一共有多少种不同字符
        int required = dictT.size();

        int l = 0, r = 0;

        //为了统计windows中各个字符是否能符合t中情况
        int formed = 0;

        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            //r指针全都走完了，该走l指针了
            while (l <= r && formed == required) {
                c = s.charAt(l);
                //取最小window
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                //如果成立，说明l走过头了，上一个才是最正确的
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

//    //优化
//    public String minWindow(String s, String t) {
//
//        if (s.length() == 0 || t.length() == 0) {
//            return "";
//        }
//
//        // 将t中各个字符的频数进行统计
//        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
//        for (int i = 0; i < t.length(); i++) {
//            int count = dictT.getOrDefault(t.charAt(i), 0);
//            dictT.put(t.charAt(i), count + 1);
//        }
//
//        // t中一共有多少种不同字符
//        int required = dictT.size();
//
//        List<Pair<Integer, Character>> filteredS = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (dictT.containsKey(c)) {
//                filteredS.add(new Pair<Integer, Character>(i, c));
//            }
//        }
//        int l = 0, r = 0;
//
//        //为了统计windows中各个字符是否能符合t中情况
//        int formed = 0;
//
//        // ans list of the form (window length, left, right)
//        int[] ans = {-1, 0, 0};
//
//        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
//
//        while (r < filteredS.size()) {
//            char c = filteredS.get(r).getValue();
//            int count = windowCounts.getOrDefault(c, 0);
//            windowCounts.put(c, count + 1);
//
//            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
//                formed++;
//            }
//
//            //r指针全都走完了，该走l指针了
//            while (l <= r && formed == required) {
//                c = filteredS.get(l).getValue();
//                int end = filteredS.get(r).getKey();
//                int start = filteredS.get(l).getKey();
//
//                if (ans[0] == -1 || end - start + 1 < ans[0]) {
//                    ans[0] = end - start + 1;
//                    ans[1] = start;
//                    ans[2] = end;
//                }
//
//                windowCounts.put(c, windowCounts.get(c) - 1);
//                //如果成立，说明l走过头了，上一个才是最正确的
//                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
//                    formed--;
//                }
//
//                l++;
//            }
//
//            r++;
//        }
//
//        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
//    }


//    //最优
//    public String minWindow(String s, String t) {
//        int count = t.length();
//        int[] map = new int[128];
//        for(char c: t.toCharArray()){
//            map[c]++;
//        }
//        int left = 0, right = 0, begin = 0, min = Integer.MAX_VALUE;
//        while(right< s.length()){
//            if(map[s.charAt(right)]>0){
//                count--;
//            }
//            map[s.charAt(right++)]--;
//            while(count == 0){
//                if(right-left<min){
//                    min = right-left;
//                    begin = left;
//                }
//                if(map[s.charAt(left)] == 0){
//                    count++;
//                }
//                map[s.charAt(left++)]++;
//            }
//        }
//        return min == Integer.MAX_VALUE?"":s.substring(begin, begin+min);
//    }
}
