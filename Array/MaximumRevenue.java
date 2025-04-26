package Array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumRevenue {

    static int M;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] quantity = new int[n];
        for(int i=0;i<n;i++){
            quantity[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        M=m;
        System.out.println(getMaximumAmount(quantity));
    }
    private static long getMaximumAmount(int[] quantity){
        int maxAmount = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(quantity.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for(int i : quantity){
            pq.add(i);
        }
        for(int i=0;i<M;i++){
            int amount = pq.poll();
            maxAmount+=amount;
            pq.add(--amount);
        }
        return maxAmount;
    }
}
