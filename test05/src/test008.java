//DFS+回溯专题-LeetCode52.N皇后II
public class test008 {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n]; //对角线
        boolean[] d2 = new boolean[2 * n]; //副对角线
        backtrack(0, cols, d1, d2, n);
        return count;
    }

    /*
      https://leetcode.com/problems/n-queens-ii/discuss/20048/Easiest-Java-Solution-(1ms-98.22)
      可以发现对于同一条副对角线，row + col 的值是相等的。
      对于同一条主对角线，row - col 的值是相等的。
      我们同样可以用一个 bool 型数组，来保存当前对角线是否有元素，把它们相加相减的值作为下标。
      对于 row - col ，由于出现了负数，所以可以加 1 个 n，由 [ - 3, 3 ] 转换为 [ 1 , 7 ] 。
    */
    private void backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            count++;
        } else {
            for (int col = 0; col < n; col++) {
                int id1 = col - row + n;
                int id2 = col + row;
                if (cols[col] || d1[id1] || d2[id2]) continue;
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                backtrack(row + 1, cols, d1, d2, n);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }
}
