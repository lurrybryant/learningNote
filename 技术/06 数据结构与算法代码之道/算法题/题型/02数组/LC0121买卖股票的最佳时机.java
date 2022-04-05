public int maxProfit(int[] prices) {
2    int maxCur = 0, maxSoFar = 0;
3    for (int i = 1; i < prices.length; i++) {
4        maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
5        maxSoFar = Math.max(maxCur, maxSoFar);
6    }
7    return maxSoFar;
8
}