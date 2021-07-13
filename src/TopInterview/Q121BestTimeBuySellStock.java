package TopInterview;

class Q121BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    private void validate() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println(profit);

        prices = new int[]{7, 6, 4, 3, 1};
        profit = maxProfit(prices);
        System.out.println(profit);
    }

    static public void main(String... args) {
        new Q121BestTimeBuySellStock().validate();
    }
}