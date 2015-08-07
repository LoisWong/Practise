
public class sellstock {
	public int maxProfit(int[] prices) {
        //在prices数组中以最低价格买入，最高价格卖出，先买入后卖出
		/*if (prices.length == 0) return 0;
		int min = prices[0];
		int max = prices[0];
		for (int i = 1; i < prices.length; i++){
			if (prices[i] < min) min = prices[i];
			if (prices[i] > max) max = prices[i];
		}
		return max-min;*/
		if (prices.length == 0) return 0;
		int min = prices[0];
		int profit = 0;
		for (int i = 1; i < prices.length; i++){
			if (prices[i] < min) min = prices[i];
			if (prices[i] - min > profit) profit = prices[i] - min;
		}
		return profit;
    }
}
