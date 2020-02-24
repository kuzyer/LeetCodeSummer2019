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
//        void union(int a, int b){
//            int fa = find(a);
//            int fb = find(b);
//            father[fb] = fa;
//        }
//    }
//    class Solution {
//
//        public int findCircleNum(int[][] M) {
//            int n = M.length;
//            UnionFind u = new UnionFind(n);
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < i; j++) {
//                    if (M[i][j] == 1)
//                        u.union(i, j); //两个人是朋友则合并朋友圈
//                }
//            }
//
//            int res = 0;
//            for (int i = 0; i < n; i++) {
//                if (u.find(i) == i) {
//                    res++; //计算朋友圈的个数
//                }
//            }
//
//            return res;
//        }
//    }
}
