package Queue;

import java.util.*;

public class MaximumBitDistance {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numbers[] = new int[n];
        for(int i=0;i<n;i++){
            numbers[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] res = getTopKBitDistances(numbers,k);
        for(int num : res){
            System.out.println(num);
        }
    }


    public static int[] getTopKBitDistances(int[] numbers, int k){
        int[] result = new int[k];
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(numbers.length, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                if(a.get(0).equals(b.get(0))){
                    return b.get(1)-a.get(1);
                }else{
                    return b.getFirst()-a.getFirst();
                }
            }
        });

        for(int num : numbers){
            int distance = findBitDistance(num);
            pq.add(new ArrayList<Integer>(Arrays.asList(distance,num)));
        }

        for(int i=0;i<k;i++){
            if(!pq.isEmpty()){
                result[i]=pq.poll().get(1);
            }
        }
        return result;
    }

   public static int findBitDistance(int number){
        int x = number;
        int maxDist = 0;
        int pos = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(x!=0){
            if((x & 1) == 1){
                list.add(pos);
            }
            x = x>>1;
            pos++;
        }
        if(list.isEmpty() || list.size()==1){
            maxDist = -1;
        }
        for(int i=1;i<list.size();i++){
            maxDist = Math.max(maxDist,list.get(i)-list.get(i-1)-1);
        }
        return maxDist;
   }
}
