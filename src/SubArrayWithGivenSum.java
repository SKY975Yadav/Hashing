import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int [] arr = {60,1,-1,40,20};
        System.out.println(isSubArrayWithGivenSum(arr, arr.length,60));
        System.out.println(Arrays.toString(indexesOfSubArrayWithGivenSum(arr, arr.length, 60)));
        System.out.println(maxLenOfSubArrayWithGivenSum(arr, arr.length,60));
        System.out.println(Arrays.toString(indexesOFMaxLenOfSubArrayWithGivenSum(arr, arr.length, 60)));
    }
    public static boolean isSubArrayWithGivenSum(int [] arr, int n,int sum){
        int cumSum = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (cumSum==sum) return true;
            if (hs.contains(cumSum-sum)){
                return true;
            }
            hs.add(cumSum);
        }
        return false;
    }

    public static int [] indexesOfSubArrayWithGivenSum(int [] arr,int n,int sum){
        int cumSum =0;
        HashMap<Integer,Integer> hmp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            cumSum +=arr[i];
            if (cumSum==sum)
                return new int[]{0,i};
            if (hmp.containsKey(cumSum-sum)){
                return new int[]{hmp.get(cumSum-sum)+1,i};
            }
            hmp.put(cumSum,i);
        }
        return new int[]{-1,-1};
    }

    public static int maxLenOfSubArrayWithGivenSum(int [] arr,int n,int sum){
        HashMap<Integer,Integer> hmp = new HashMap<>();
        int cumSum = 0,res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (cumSum == sum)
                res = i+1;
            if (!hmp.containsKey(cumSum)){
                hmp.put(cumSum,i);
            }
            if (hmp.containsKey(cumSum-sum)){
                res = Math.max(res, i - hmp.get(cumSum-sum));
            }
        }
        System.out.println(hmp);
        return res;
    }
    public static int [] indexesOFMaxLenOfSubArrayWithGivenSum(int [] arr,int n,int sum){
        HashMap<Integer,Integer> hs = new HashMap<>();
        int [] resArr = new int[2];
        int cumSum = 0;
        boolean bol =false;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cumSum += arr[i];
            if (cumSum==sum) {
                bol = true;
                res = i+1;
                resArr[1] = i;
            }
            if (!hs.containsKey(cumSum)){
                hs.put(cumSum,i);
            }
            if (hs.containsKey(cumSum - sum)){
                if (res<i-hs.get(cumSum - sum)){
                    res =i-hs.get(cumSum - sum);
                    resArr[0] = hs.get(cumSum-sum)+1;
                    resArr[1] = i;
                    bol = true;
                }
            }
        }
        if (!bol) return new int[]{-1,-1};
        return resArr;
    }
}
