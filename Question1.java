import java.util.Scanner;

public class Question1 {

    // Function to calculate the maximum profit
    public static int calculateMaxProfit(int[] prices, int n) {
        // If there are less than 2 days, no transaction can be made
        if (n < 2) {
            return 0;
        }

        // Initialize minimum price and maximum profit
        int minPrice = prices[0];
        int maxProfit = 0;

        // Traverse through the prices to find the best buy/sell day
        for (int i = 1; i < n; i++) {
            // Check if selling today will give a higher profit
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            // Update the minimum price if today's price is lower
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Input handling
        Scanner sc = new Scanner(System.in);
        
        // Reading the number of days
        int n = sc.nextInt();
        
        // Reading the stock prices
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Calculate and print the maximum profit
        int maxProfit = calculateMaxProfit(prices, n);
        System.out.println(maxProfit);

        sc.close();
    }
}
