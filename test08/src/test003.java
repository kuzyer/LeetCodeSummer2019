//动态规划专题-LeetCode63.不同路径II
public class test003 {
    /*
        动态规划
        dp[i][j] = dp[i][j-1] + dp[i-1][j];
        当该处有建筑物，即为1时，dp[i][j] = 0
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if (j > 0) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}
