import java.util.ArrayList;
import java.util.LinkedList;

class ChainHashing{
    private final int bucket;
    private final ArrayList<LinkedList<Integer>> table ;
    ChainHashing(int b){
        bucket = b;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i=0;i<b;i++){
            table.add(new LinkedList<Integer>());
        }
    }
    void insert(int data){
        int key = data % bucket;
        table.get(key).add(data);
    }
    void delete(int data){
        int key = data % bucket;
        table.get(key).remove(Integer.valueOf(data));
    }
    boolean search(int data){
        int key = data % bucket;
        return table.get(key).contains(data);
    }
    void showData(){
        for (LinkedList<Integer> i : table){
            System.out.println(i);
        }
    }
}
public class ImplementationOfChaining {
    public static void main(String[] args) {
        ChainHashing ch = new ChainHashing(10);
//        Insert the Data
        for (int i =1 ; i<=10;i++){
            ch.insert(i*4);
        }
//        To Access the data:
        System.out.println("Before Removing : ");
        ch.showData();
//        To delete/remove the data
        ch.delete(32);
        System.out.println("After Removing 32 : ");
        ch.showData();
//        To search the data:
//        System.out.println(ch.search(4));
    }

}
