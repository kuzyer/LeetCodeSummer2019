//基本数据结构专题-LeetCode547.朋友圈
public class test006 {
    //并查集, 路径压缩
    int[] p = new int[200];

    private int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }


    public int findCircleNum(int[][] M) {
        int n = M.length;
        for (int i = 0; i < n; i++)
            p[i] = i;

        int res = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] != 1)
                    continue;
                if (find(i) != find(j)) {
                    p[find(i)] = find(j);
                    res--;
                }
            }
        }

        return res;
    }
}
