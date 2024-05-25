import java.util.Arrays;
import java.util.HashMap;

public class LongestCommonSpanWithSameSumInTwoArrays {
    public static void main(String[] args) {
        int [] arr1 = {0,1,1,1,0,0};
        int [] arr2 = {1,1,1,1,1,1};
        System.out.println(maxLenCommonSpanWithSameSumInTwoArrays(arr1,arr2, arr1.length));
    }
    public static int maxLenCommonSpanWithSameSumInTwoArrays(int [] arr1,int [] arr2,int n){//Given two Arrays with same length and we need to find the sub array whose sum is same in both arrays with same length

        int [] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr1[i] - arr2[i];
        }
        System.out.println(Arrays.toString(temp));
        HashMap<Integer,Integer> hmp = new HashMap<>();
        int cumSum = 0,res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            cumSum += temp[i];

            if (cumSum == 0){
                res = i+1;
            }
            if (hmp.containsKey(cumSum)){
                res = Math.max(res,i - hmp.get(cumSum));
            }
            else hmp.put(cumSum,i);
        }
        return res==Integer.MIN_VALUE?0:res;

    }
}
