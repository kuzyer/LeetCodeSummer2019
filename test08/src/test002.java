import java.util.List;

//动态规划专题-LeetCode120.三角形最小路径和
public class test002 {
    /*
        点(i,j)(i,j)的下一行的相邻数字是(i+1,j)(i+1,j)和(i+1,j+1)(i+1,j+1)。
        最小路径和：f(i,j)=(i,j)+min(f(i+1,j),f(i+1,j+1))
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //新res[j] = 新行点 + 旧行两点比较
                res[j] = triangle.get(i).get(j) + Math.min(res[j], res[j + 1]);
            }
        }
        return res[0];
    }
}
