import java.util.ArrayList;
import java.util.List;

//DFS+回溯专题-LeetCode216.组合总和III
public class test007 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        combination(list, new ArrayList<>(), k, n, 1);
        return list;
    }

    private void combination(List<List<Integer>> list, List<Integer> tempList, int k, int n, int start) {
        if (tempList.size() == k && n == 0) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i <= 9; i++) {
                tempList.add(i);
                combination(list, tempList, k, n - i, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
