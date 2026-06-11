public class ShoppingKnapsack {

    static int knapsack(int W, int[] prices, int[] values, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];

                if (prices[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        dp[i - 1][w - prices[i - 1]] + values[i - 1]
                    );
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] prices = {200, 700};
        int[] values = {5, 10};
        int budget = 1000;

        int maxVal = knapsack(budget, prices, values, prices.length);

        System.out.println("Maximum Value within Budget Rs." + budget + ": " + maxVal);
        System.out.println("Selected: Mobile Cover + Power Bank");
        System.out.println("Total Cost: Rs.900  Total Value: 15");
    }
}