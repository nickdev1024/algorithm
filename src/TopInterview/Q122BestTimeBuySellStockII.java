package TopInterview;

class Q122BestTimeBuySellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    private void validate() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println(profit);

        prices = new int[]{1, 2, 3, 4, 5};
        profit = maxProfit(prices);
        System.out.println(profit);

        prices = new int[]{7, 6, 4, 3, 1};
        profit = maxProfit(prices);
        System.out.println(profit);
    }

    static public void main(String... args) {
        new Q122BestTimeBuySellStockII().validate();
    }
}