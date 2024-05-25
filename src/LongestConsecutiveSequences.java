import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequences {
    public static void main(String[] args) {
        int [] arr = {5,9,7,1,2,4,10,3,34,12,19};
        System.out.println(maxLenOfConsecutiveSeq(arr, arr.length));
    }
    public static int maxLenOfConsecutiveSeq(int [] arr,int n){
        HashSet<Integer> hs = new HashSet<>();
        int res = 1;

        for (int x : arr){
            hs.add(x);
        }
        for (int x : hs){
            if (!hs.contains(x-1)){
                int count = 1;
                while (hs.contains(x+count)){
                    count++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
