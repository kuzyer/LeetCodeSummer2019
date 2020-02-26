//动态规划专题-LeetCode518.零钱兑换II
public class test008 {
    /*
        f(j) = f(j) + f(j−coins(i))
    */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j] += f[j - coins[i]];
            }
        }

        return f[amount];
    }
}
