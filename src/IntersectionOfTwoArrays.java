import java.util.*;


public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int [] arr1 = {4,2,6,1,6,8,2,5,7};
//        int [] arr2 = {2,16,18,17,8,5};
//        System.out.println(intersectionOfTwoArrays(arr1,arr2, arr1.length, arr2.length));

        int [] temp = {1,1,2,3,3};
        System.out.println(maximum_sum(temp.length, temp,3));
    }
    public static ArrayList<Integer> intersectionOfTwoArrays(int [] arr1, int[] arr2, int n1, int n2){
        HashSet<Integer> hs = new HashSet<>();
        for (int x : arr1){
            hs.add(x);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            if (hs.contains(arr2[i])){
                al.add(arr2[i]);
                hs.remove(arr2[i]);
            }
        }
        return al;
    }

    static long maximum_sum(int N,int[]A,int K){
        //code here

        HashMap<Integer,Integer> hmp = new HashMap<>();

        for(int i = 0;i<N;i++){
            hmp.put(A[i],hmp.getOrDefault(A[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> {
                    int freqComparison = b.getValue().compareTo(a.getValue());
                    if (freqComparison == 0) {
                        return b.getKey().compareTo(a.getKey()); // Natural order if frequencies are equal
                    }
                    return freqComparison;
        });

        // Add all entries from the frequency map to the max-heap
        maxHeap.addAll(hmp.entrySet());

        long sum = 0;

        System.out.println(maxHeap);
        // Pick K elements with the highest frequency
        for (int i = 0; i < K; i++) {
            if (maxHeap.isEmpty()) break; // In case K is larger than the number of unique elements

            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            System.out.println(maxHeap);
            int element = entry.getKey();
            int freq = entry.getValue();

            sum += element;

            // Decrease the frequency and put it back into the max-heap if it's still greater than zero
            if (freq > 1) {
                maxHeap.offer(new AbstractMap.SimpleEntry<>(element, freq - 1));
            }
        }

        return sum;

    }
}
