import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CountDistinctElementInEveryWindow {
    public static void main(String[] args) {
        int [] arr = {12,78,1,12,12,4,1,1,34};
        System.out.println(Arrays.toString(countDistElemInEveryWindow(arr, arr.length, 5)));
    }
    public static int [] countDistElemInEveryWindow(int [] arr, int n,int k){
        if (k>n) return new int[]{-1};
        int [] res = new int[n-k+1];
        HashMap<Integer,Integer> hmp = new HashMap<>();
        for (int i = 0; i < k; i++) {
            hmp.put(arr[i], hmp.getOrDefault(arr[i],0)+1);
        }
        res [0] = hmp.size();
        for (int i = k; i < n; i++) {
            int x = arr[i-k];
            if (hmp.get(x)==1)
                hmp.remove(x);
            else hmp.put(x, hmp.get(x)-1);
            hmp.put(arr[i], hmp.getOrDefault(arr[i],0)+1);
            res[i-k+1] = hmp.size();
        }
        return res;
    }

    static HashMap<Integer,Integer> mp = new HashMap<>();
    public static void findAll()
    {
        //Your code here
        int x= 1,temp = -1;
        while(x<=1000000){
            String st = Integer.toString(x);
            if(st.contains("1") || st.contains("2") || st.contains("3")){
                temp = 1;
            }
            mp.put(x,temp);
            temp = -1;
            x++;
        }
    }
}
