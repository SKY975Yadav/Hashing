import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int [] arr= {2,4,6,12,6,13,52,34};
        System.out.println(isPairWithGivenSum(arr, arr.length,13));
    }
    public static boolean isPairWithGivenSum(int [] arr, int n,int k){
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (hs.contains(k-arr[i]))
                return true;
            else hs.add(arr[i]);
        }
        return false;
    }
}
