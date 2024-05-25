import java.util.HashSet;
import java.util.List;

public class UnionOfTwoUnsortedArrays {
    public static void main(String[] args) {
        int [] arr1 = {3,6,2,6,1,3,12,9,12,7,8};
        int [] arr2 = {4,6,2,7,8,2,5,6,1,4,12,34};
        System.out.println(unionOfTwoArrays(arr1,arr2, arr1.length, arr2.length));
    }
    public static List<Integer> unionOfTwoArrays(int [] arr1, int []arr2, int n1, int n2) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : arr1){
            hs.add(x);
        }
        for (int y : arr2){
            hs.add(y);
        }
        return  hs.stream().toList();
    }
}
