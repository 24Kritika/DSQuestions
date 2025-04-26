package Queue;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PositivePrefixSum {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(maxPosPrefixes(arr));
    }

    public static int maxPosPrefixes(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count=0,sum=0;
        for (int j : arr) {
            pq.add(j);
        }
        while(!pq.isEmpty()){
            sum+=pq.poll();
            if(sum<=0){
                break;
            }
            count++;
        }
        return count;
    }
}
