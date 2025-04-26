package Queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ServerManagement {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//Number of servers
        int[] serverCapacity = new int[n];
        for(int i=0;i<n;i++){
            serverCapacity[i] = sc .nextInt();
        }
        int [] incomingRequests = new int[n];
        for(int i=0;i<n;i++){
            incomingRequests[i] = sc .nextInt();
        }
        int k = sc.nextInt();//Count of servers that can be doubled in capacity
        System.out.println(getMaxRequests(serverCapacity,incomingRequests,k));
    }

    public static long getMaxRequests(int[] serverCapacity,int[] incomingRequests,int k){
        int n = serverCapacity.length;
        int currentCapacity, increasedServerCapacity;
        long maxCapacity=0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            currentCapacity = Math.min(serverCapacity[i],incomingRequests[i]);
            increasedServerCapacity = Math.min(serverCapacity[i]*2,incomingRequests[i]);
            pq.offer(increasedServerCapacity-currentCapacity);
            maxCapacity+=currentCapacity;
        }

        for(int i=0;i<k;i++){
            if(!pq.isEmpty()) {
                maxCapacity += pq.poll();
            }
        }

        return maxCapacity;
    }
}
