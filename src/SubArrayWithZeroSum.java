import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int [] arr = {1,1,-1,-1};
        System.out.println(isSubArrayWithZeroSum(arr, arr.length));
        System.out.println(Arrays.toString(indexesOFSubArrayWithZeroSum(arr, arr.length)));
        System.out.println(maxLengthOfSubArrayWithZero(arr,arr.length));
        System.out.println(Arrays.toString(indexesOFMaxLenOfSubArrayWithSumZero(arr, arr.length)));
    }
    public static boolean isSubArrayWithZeroSum(int [] arr,int n){
        HashSet<Integer> hs = new HashSet<>();
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (hs.contains(cumSum))
                return true;
            if (cumSum==0)return true;
            hs.add(cumSum);
        }
        return false;
    }
    public static int [] indexesOFSubArrayWithZeroSum(int [] arr,int n){
        HashMap<Integer,Integer> hs = new HashMap<>();
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (cumSum==0) {
                return new int[]{0, i};
            }
            if (hs.containsKey(cumSum))
                return new int[]{hs.get(cumSum)+1,i};
            hs.put(cumSum,i);
        }
        return new int[]{-1,-1};
    }

    public static int maxLengthOfSubArrayWithZero(int [] arr,int n){
        HashMap<Integer,Integer> hs = new HashMap<>();
        int cumSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (cumSum==0) {
                res = i+1;
            }
            if (hs.containsKey(cumSum)){
                res = Math.max(res,i-hs.get(cumSum));
            }
            else hs.put(cumSum,i);
        }
        return res;
    }
    public static int [] indexesOFMaxLenOfSubArrayWithSumZero(int [] arr,int n){
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
