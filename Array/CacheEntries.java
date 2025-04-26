package Array;

import java.util.*;

public class CacheEntries {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int elementCount = sc.nextInt();
        String[][] cache_entries = new String[n][elementCount];
        for(int i=0;i<n;i++){
            for(int j=0;j<elementCount;j++){
                cache_entries[i][j] = sc.next();
            }
        }
        int q = sc.nextInt();
        int q_element = sc.nextInt();
        String[][] queries = new String[q][q_element];
        for(int i=0;i<q;i++){
            for(int j=0;j<q_element;j++){
                queries[i][j] = sc.next();
            }
        }
        int answer[] = getQueryAnswers(cache_entries,queries);
        for(int res:answer){
            System.out.println(res);
        }
    }

    private static int[] getQueryAnswers(String[][] cache_entries,String[][] queries){
        Map<String,ArrayList<String>> map = new HashMap<>();
        int cache_len = cache_entries.length;
        int q_len = queries.length;
        int[] answer = new int[q_len];

        for (String[] cacheEntry : cache_entries) {
            map.put(cacheEntry[0], new ArrayList<String>(Arrays.asList(cacheEntry[1], cacheEntry[2])));
        }

        for(int i=0;i<q_len;i++){
            answer[i]=Integer.parseInt(map.get(queries[i][1]).get(1));
        }
        return answer;
    }
}
