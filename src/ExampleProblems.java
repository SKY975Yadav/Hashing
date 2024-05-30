import java.util.*;

class PracticeProblems {
    //  Problem 1 check whether Sub Array with sum = 0 is present in the array or not
//    Sub Array with sum Zero we store the prefix sum of elements one by one in hash set then check weather the
//    prefix sum is already present or not if yes then it guarantee that there is the sub array with sum = zero
//   Also check weather the preSum == 0 if yes then written true
    //Naive Solution: TC = O(n2), ASC = O(1)

    public boolean NaiveSubArrayWithSumZero(int [] a){
        for(int i=0;i<a.length;i++){
            int curSum=0;
            for (int j=i;j<a.length;j++){
                curSum += a[j];
                if (curSum==0){
                    return true;
                }
            }
        }
        return false;
    }
//    Best Solution : TC :  O(n)  and ASC : O(n)
    public boolean subArrayWithSumZero(int [] a){
        HashSet<Integer> hs = new HashSet<>();
        int preSum = 0;
        for (int j : a) {
            preSum += j;
            if (hs.contains(preSum)) {
                return true;
            }
            if (preSum == 0) {
                return true;
            }
            hs.add(preSum);
        }
        return false;
    }
//    Problem 2 : Check the sub array with given sum is present in array or not
//    Sub Array with given sum we store the prefix sum of elements one by one in hash set then check weather the
//    prefix sum - given Sum is already present or not if yes then it guarantee that there is the sub array with given Sum
//    Also check weather the preSum == sum if yes then written true

//    Naive Solution : TC = O(n2), ASC = O(1)
    public boolean NaiveSubArrayWithGivenSum(int [] a,int sum){
        for (int i=0;i<a.length;i++){
            int curSum = 0;
            for (int j =i ;j<a.length;j++){
                curSum += a[j];
                if (curSum == sum){
                    return true;
                }
            }
        }
        return false;
    }
//    Best Solution : TC :  O(n)  and ASC : O(n)
    public boolean subArrayWithGivenSum(int [] a,int sum){
        HashSet<Integer> hs = new HashSet<>();
        int preSum=0;
        for (int j : a) {
            preSum += j;
            if (hs.contains(preSum - sum)) {
                return true;
            }
            if (preSum == sum) {
                return true;
            }
            hs.add(preSum);
        }
        return false;
    }
//    Problem 3 : Find out the length of the longest sub array with given sum
//    Native : TC = O(n2), ASC = O(1)
    public int naiveLengthOfLongestSubArrayWithGivenSum(int []a,int sum){
        int maxLength=0;
        for (int i=0;i<a.length;i++){
            int count=0;
            int curSum=0;
            for (int j=i;j<a.length;j++){
                curSum += a[j];
                count++;
                if (curSum==sum){
                    if (maxLength<count) {
                        maxLength = count;
                    }
                }
            }
        }
        return maxLength;
    }
//    Best solution :  TC :  O(n)  and ASC : O(n)
    public int lengthOfLongestSubArrayWithGivenSum(int []a,int sum){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int maxLength =0;
        int preSum=0;
        for (int i=0;i<a.length;i++){
            preSum += a[i];
            if (preSum == sum){
                maxLength = i+1;
            }
            if (!mp.containsKey(preSum)){
                mp.put(preSum,i);
            }
            if (mp.containsKey(preSum - sum)){
                if (maxLength<(i- mp.get(preSum - sum))){
                    maxLength = i - mp.get(preSum - sum);
                }
            }
        }
        return  maxLength;
    }
//    Problem 4 Length Longest sub array with equal 0's and 1's
//    The Idea is simple convert zeros into -1 and apply same process as problem 3 with sum = 0
    public int lengthOfLongestSubArrayWithEqualZerosAndOnes(int []a, int sum){
        for (int i = 0 ; i<a.length;i++){
         if (a[i]==0)
             a[i]=-1;
        }
        HashMap<Integer,Integer> mp = new HashMap<>();
        int maxLength =0;
        int preSum=0;
        for (int i=0;i<a.length;i++){
            preSum += a[i];
            if (preSum == sum){
                maxLength = i+1;
            }
            if (!mp.containsKey(preSum)){
                mp.put(preSum,i);
            }
            if (mp.containsKey(preSum - sum)){
                if (maxLength<(i- mp.get(preSum - sum))){
                    maxLength = i - mp.get(preSum - sum);
                }
            }
        }
        return  maxLength;
    }
//  Problem 5 : find distinct Elements in array
    public int distinctElements(Integer []a){
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(a));
        return hs.size();
    }
    //Problem 6 : Frequencies of array elements [10,23,23,15,10]
//    Naive Solution : TC : O(n2)
    public void naiveFrequenciesOfArrayElements(int []a){
        for (int i=0;i<a.length;i++){
            boolean bol = false;
            for (int j=0;j<i;j++){
                if (a[i]==a[j]) {
                    bol = true;
                    break;
                }
            }
            if (bol)
                continue;
            int freq = 1;
            for (int j =i+1;j<a.length;j++){
                if (a[i]==a[j]){
                    freq++;
                }
            }
            System.out.println(a[i]+" : "+freq);
        }
    }
//    Best Solution : TC : O(N)
    public void frequenciesOfArrayElements(int []a){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int x : a)
            hm.put(x,hm.getOrDefault(x,0)+1);
        for (Map.Entry<Integer,Integer> me : hm.entrySet())
            System.out.println(me.getKey()+" : "+me.getValue());
    }
}
public class ExampleProblems {
    public static void main(String[] args) {
        PracticeProblems ps = new PracticeProblems();
//        Problem 1 :
//        int [] ar = {34, 62, 64,-32, 23,9};
//        System.out.println(ps.NaiveSubArrayWithSumZero(ar));
//        System.out.println(ps.subArrayWithSumZero(ar));
        //Problem 2 :
//        int [] ar = {3,1,0,7,3,5};
//        System.out.println(ps.subArrayWithGivenSum(ar,4));
//        System.out.println(ps.NaiveSubArrayWithGivenSum(ar,30));
        //Problem 3 :
//        int [] ar = {3,6,4,5,8,9,3,12,1,1,1,3,4};
//        System.out.println(ps.naiveLengthOfLongestSubArrayWithGivenSum(ar,10));
//        System.out.println(ps.lengthOfLongestSubArrayWithGivenSum(ar,10));
        //Problem 4 :
//        int [] ar = {1,0,1,1,1,0,0,1,1,0};
//        System.out.println(ps.lengthOfLongestSubArrayWithEqualZerosAndOnes(ar,0));
        //Problem 5 :
//        Integer [] ar = {45,34,23,45,23,64,23,45};
//        System.out.println(ps.distinctElements(ar));
        //Problem 6 :
//        int [] a = {34,23,52,23,34,25};
////        ps.naiveFrequenciesOfArrayElements(a);
//        ps.frequenciesOfArrayElements(a);
    }
}
