public int maxProfit(int[] prices) {
2    int total = 0;
3    for (int i = 0; i < prices.length - 1; i++)
4        total += Math.max(prices[i + 1] - prices[i], 0);
5    return total;
6}

