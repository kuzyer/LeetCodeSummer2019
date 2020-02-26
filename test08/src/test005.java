//动态规划专题-LeetCode198.打家劫舍
public class test005 {
    /*
        1. 令f[i]表示盗窃了第i个房间所能得到的最大收益，g[i]表示不盗窃第i个房间所能得到的最大收益。
        2. f[i] = g[i-1] + nums[i]  g[i] = max(f[i-1], g[i-1])
        3. 初始值f[0] = nums[0], g[0] = 0，答案为max(f[n - 1], g[n - 1])。
    */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] f = new int[n + 1];
        int[] g = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = g[i - 1] + nums[i - 1];
            g[i] = Math.max(f[i - 1], g[i - 1]);
        }
        return Math.max(f[n], g[n]);
    }
}
