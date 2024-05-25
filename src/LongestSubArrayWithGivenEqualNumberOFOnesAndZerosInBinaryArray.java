import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArrayWithGivenEqualNumberOFOnesAndZerosInBinaryArray {
    public static void main(String[] args) {
        int [] arr = {1,1,0,0,1,1,1,1,1,0,0,0,0};
        System.out.println(maxLenOfSubArrayWithEqualOnesAndZeros(arr, arr.length));
        System.out.println(Arrays.toString(indexesOFMaxLenOfSubArrayWithEqualsZeroAndOnes(arr, arr.length)));
    }
    public static int maxLenOfSubArrayWithEqualOnesAndZeros(int [] arr,int n){
        for (int i = 0; i < n; i++) {
            if (arr[i]==0){
                arr[i] = -1;
            }
        }
        HashMap<Integer,Integer> hmp = new HashMap<>();
        int cumSum = 0,res = 0;
        for (int i = 0; i <n ; i++) {
            cumSum += arr[i];
            if (cumSum==0)
                res = i+1;
            if (hmp.containsKey(cumSum)){
                res = Math.max(res , i- hmp.get(cumSum));
            }
            else hmp.put(cumSum,i);
        }
        return res;
    }
    public static int [] indexesOFMaxLenOfSubArrayWithEqualsZeroAndOnes(int [] arr,int n){
        for (int i = 0; i < n; i++) {
            if (arr[i]==0)
                arr[i] = -1;
        }
        HashMap<Integer,Integer> hs = new HashMap<>();
        int [] resArr = new int[2];
        int cumSum = 0;
        boolean bol =false;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (cumSum==0) {
                bol = true;
                res = i+1;
                resArr[0] = 0;
                resArr[1] = i;
            }
            if (hs.containsKey(cumSum)){
                if (res<i-hs.get(cumSum)){
                    res =i-hs.get(cumSum);
                    resArr[0] = hs.get(cumSum)+1;
                    resArr[1] = i;
                    bol = true;
                }
            }
            else hs.put(cumSum,i);
        }
        if (!bol) return new int[]{-1,-1};
        return resArr;
    }
}
