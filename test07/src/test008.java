import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//基本数据结构专题-LeetCode692.前K个高频单词
public class test008 {
    //PriorityQueue 优先队列
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(
                (s1, s2) -> map.get(s1) == map.get(s2) ? s2.compareTo(s1) : map.get(s1) - map.get(s2)
        );

        for (String str : map.keySet()) {
            queue.offer(str);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ans.add(0, queue.poll());
        }

        return ans;

    }
}
