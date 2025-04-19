package Array;

import java.util.*;

public class GoodArray {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int q = sc.nextInt();
        int size = sc.nextInt();
        int[][] queries = new int[q][size];
        for(int i=0;i<q;i++){
            for(int j=0;j<size;j++){
                queries[i][j]=sc.nextInt();
            }
        }
        int answer[] = getQueryResults(N,queries);
        for(int i : answer){
            System.out.println(i);
        }
    }

    private static int[] getQueryResults(long N,int queries[][]){
        int q_len = queries.length;
        int answer[] = new int[q_len];
        ArrayList<Long> goodArray = findGoodArray(N);
        long ans;
        for(int i=0;i<q_len;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int m = queries[i][2];
            ans = 1;
            for(int j=l-1;j<=r-1;j++){
                ans = (ans*goodArray.get(j))%m;
            }
            answer[i] = (int)ans;
        }
        return answer;
    }

    private static ArrayList<Long> findGoodArray(long N){
        long closestPower;
        long powerValue;
        ArrayList<Long> goodArray = new ArrayList<>();
        while(N!=0L){
            closestPower = (long)(Math.log(N)/Math.log(2));
            powerValue = (long)Math.pow(2,closestPower);
            goodArray.add(powerValue);
            N-=powerValue;
        }
        Collections.sort(goodArray,Comparator.naturalOrder());
        return goodArray;
    }
}
