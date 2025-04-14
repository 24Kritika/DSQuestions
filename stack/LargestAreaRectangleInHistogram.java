package stack;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaRectangleInHistogram {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int area = getMaxArea(arr);
        System.out.println("Maximum Area="+area);
    }
    private static int getMaxArea(int[] arr){
        int maxArea = 0;
        int prevSmall[] = findPreviousSmaller(arr);
        int nextSmall[] = findNextSmaller(arr);
        for(int i=0;i<arr.length;i++){
          maxArea = Math.max(maxArea,arr[i]*(nextSmall[i]-prevSmall[i]-1));
        }
        return maxArea;
    }

    private static int[]  findPreviousSmaller(int arr[]){
        int n = arr.length;
        int[] prev = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            prev[i]=-1;
        }
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                s.pop();
            }
            if(!s.isEmpty()){
                prev[i]=s.peek();
            }
            s.push(i);
        }
        return prev;
    }

    private static int[]  findNextSmaller(int arr[]){
        int n = arr.length;
        int[] next = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            next[i]=n;
        }
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[i]<arr[s.peek()]){
                next[s.pop()]=i;
            }
            s.push(i);
        }
        return next;
    }

}
