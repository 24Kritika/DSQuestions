package Array;

import java.util.Scanner;

public class EqualPrice {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//Number of items
        int[] price = new int[n];
        for(int i=0;i<n;i++){
            price[i] = sc .nextInt();
        }
        int q = sc.nextInt();
        int [] query = new int[q];
        for(int i=0;i<q;i++){
            query[i] = sc .nextInt();
        }
        long ans[] = countMinimumOperations(price,query);
        for(long count : ans){
            System.out.println(count);
        }
    }

    public static long[] countMinimumOperations(int[] price,int[] query){
        int q = query.length;
        int n = price.length;
        long[] result = new long[q];
        for(int i=0;i<q;i++){
            for (int k : price) {
                result[i] += (long) (Math.abs(query[i] - k));
            }
        }
        return result;
    }
}
