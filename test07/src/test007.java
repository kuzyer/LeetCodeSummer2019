//基本数据结构专题-LeetCode684.冗余连接
public class test007 {

    //并查集, 路径压缩
    int[] p = new int[2000000];

    private int find(int x) {
        if (p[x] != x)
            p[x] = find(p[x]);
        return p[x];
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for (int i = 0; i <= edges.length; i++) {
            p[i] = i;
        }
        int[] res = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (find(a) == find(b)) {
                res[0] = a;
                res[1] = b;
            }
            p[find(a)] = find(b);
        }

        return res;
    }


    //定义了模板

//    public class UnionFind {
//        private int[] father;
//        private int count;
//        public UnionFind (int n) {
//            father = new int[n];
//            for (int i = 0; i < n; i++) {
//                father[i] = i;
//            }
//        }
//        int find(int x) {
//            if (father[x] == x) {
//                return x;
//            }
//            //路径压缩
//            father[x] = find(father[x]);
//            return father[x];
//        }
//        boolean union(int a, int b){
//            //判断a和b是否本身在一个集合里
//            int fa = find(a);
//            int fb = find(b);
//            boolean res = false;
//            if (fa == fb)
//                res = true;
//            father[fb] = fa;
//            return res;
//        }
//    }
//    class Solution {
//        public int[] findRedundantConnection(int[][] edges) {
//            int n = edges.length;
//            UnionFind u = new UnionFind(n + 1);
//            int[] res = new int[2];
//            for (int i = 0; i < n; i++) {
//                int a = edges[i][0];
//                int b = edges[i][1];
//                if (u.union(a, b)) {
//                    res[0] = a;
//                    res[1] = b;
//                }
//            }
//
//            return res;
//        }
//    }
}
