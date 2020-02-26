//动态规划专题-LeetCode72.编辑距离
public class test007 {
    /*
        状态表示：f[i,j]f[i,j] 表示将 word1 的前 ii 个字符变成 word2 的前 jj 个字符，最少需要进行多少次操作。
        状态转移，一共有四种情况：
        1.将 word1[i]word1[i] 删除或在 word2[j]word2[j] 后面添加 word1[i]word1[i]，则其操作次数等于 f[i−1,j]+1f[i−1,j]+1；
        2.将 word2[j]word2[j] 删除或在 word1[i]word1[i] 后面添加 word2[j]word2[j]，则其操作次数等于 f[i,j−1]+1f[i,j−1]+1；
        3.如果 word1[i]=word2[j]word1[i]=word2[j]，则其操作次数等于 f[i−1,j−1]f[i−1,j−1]；
        4.如果 word1[i]≠word2[j]word1[i]≠word2[j]，则其操作次数等于 f[i−1,j−1]+1f[i−1,j−1]+1；
    */
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n == 0 || m == 0)
            return n + m;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 0;
        for (int i = 1; i <= n; i++)
            f[i][0] = i;
        for (int j = 1; j <= m; j++)
            f[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                f[i][j] = Math.min(f[i][j], f[i - 1][j] + 1);
                f[i][j] = Math.min(f[i][j], f[i][j - 1] + 1);
            }
        }

        return f[n][m];

    }
}
