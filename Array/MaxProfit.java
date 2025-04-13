import java.util.*;
public class MaxProfit {

    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] prices = new int[n];
         for(int i=0;i<n;i++){
             prices[i] = sc.nextInt();
         }
         int profit = findMaxProfit(prices);
         System.out.println("Profit="+profit);
    }

    public static int findMaxProfit(int[] prices){
        if(prices.length<2){
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i=0;i<prices.length;i++){
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }
}
