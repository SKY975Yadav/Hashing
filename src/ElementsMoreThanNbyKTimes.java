import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ElementsMoreThanNbyKTimes {
    public static void main(String[] args) {
        int arr[] = new int[]{10, 10, 60, 20, 20, 20, 10, 20, 10};

        int n = arr.length;
        int k = 3;
        System.out.println(elementsNByK(arr, n, k));
        System.out.println(elementsNbyK_UsingMooreVoteAlgo(arr, arr.length,k));
    }
    char nonrepeatingCharacter(String s)
    {
        //Your code here
        HashMap<Character,Integer> hmp = new HashMap<>();
        char [] temp = s.toCharArray();
        for(int i=0;i<temp.length;i++){
            hmp.put(temp[i],hmp.getOrDefault(temp[i],0)+1);
        }
        for(int i=0;i<temp.length;i++){
            if(hmp.containsKey(temp[i]) && hmp.get(temp[i])==1){
                return temp[i];
            }
        }
        return '$';
    }

    public static ArrayList<Integer> elementsNByK(int [] arr, int n, int k) { // TC : O(n) , SC : O(N) but no efficient because of space complexity
        HashMap<Integer, Integer> m = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int x : arr) {
            int temp = m.getOrDefault(x, 0) + 1;
            if (temp != 0) {
                m.put(x, temp);
            }
            if (temp > n / k) {
                al.add(x);
                m.put(x, -1);
            }
        }
        return al;
    }

    // Using moore vote algo

    public static ArrayList<Integer> elementsNbyK_UsingMooreVoteAlgo(int[] arr, int n, int k) {  //TC : O(n*k) SC : (k)
        HashMap<Integer, Integer> hmp = new HashMap<>(k - 1);
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            if (hmp.containsKey(arr[i])) {
                hmp.put(arr[i], hmp.get(arr[i]) + 1);
            } else if (hmp.size() < k-1) {
                hmp.put(arr[i], 1);
            } else {
                hmp.replaceAll((key, v) -> v - 1);
                hmp.entrySet().removeIf(entry -> entry.getValue()==0);
            }
        }
        HashMap<Integer,Integer> actualCounts = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hmp.containsKey(arr[i])){
                actualCounts.put(arr[i],actualCounts.getOrDefault(arr[i],0)+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : actualCounts.entrySet()) {
            if (entry.getValue() > n / k) {
                al.add(entry.getKey());
            }
        }

//        for (Map.Entry<Integer, Integer> mp : hmp.entrySet()) {  This takes O(n*k)  but above code for traversal take O(n)
//            for (int i = 0; i < n; i++) {
//                int count= 0;
//                if (mp.getKey()==arr[i])
//                    count++;
//                if (count>n/k){
//                    al.add(mp.getKey());
//                }
//            }
//        }
        return al;
    }
}
