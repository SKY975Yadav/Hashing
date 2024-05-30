import java.util.Arrays;
class LinearProbing
{
    int[] arr;
    int cap,size;

    LinearProbing(int c)
    {
        cap=c;
        size=0;
        arr=new int[cap];
        for(int i=0;i<cap;i++)
            arr[i]=-1;
    }

    int hash(int key){
        return key%cap;
    }

    boolean insert(int key)
    {
        if(size==cap)
            return false;
        int i=hash(key);
        while(arr[i]!=-1 && arr[i]!=-2 && arr[i]!=key)
            i=(i+1)%cap;
        if(arr[i]==key)
            return false;
        else{
            arr[i]=key;
            size++;
            return true;
        }
    }
    boolean search(int key)
    {
        int h=hash(key);
        int i=h;
        while(arr[i]!=-1){
            if(arr[i]==key)
                return true;
            i=(i+1)%cap;
            if(i==h)
                return false;
        }
        return false;
    }
    boolean erase(int key)
    {
        int h=hash(key);
        int i=h;
        while(arr[i]!=-1){
            if(arr[i]==key){
                arr[i]=-2;
                return true;
            }
            i=(i+1)%cap;
            if(i==h)
                return false;
        }
        return false;
    }

    public void display() {
        System.out.println("Hash Table (Linear Probing):");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }
}
class QuadraticProbingHashTable {
    private int[] table;
    private int size;

    public QuadraticProbingHashTable(int capacity) {
        table = new int[capacity];
        Arrays.fill(table, -1); // Initialize all slots to -1 (indicating empty)
        size = 0;
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void insert(int key) {
        if (size == table.length) {
            System.out.println("Hash table is full, cannot insert more elements.");
            return;
        }

        int index = hash(key);
        int i = 1;
        while (table[index] != -1) {
            index = (index + i * i) % table.length; // Quadratic probing
            i++;
        }
        table[index] = key;
        size++;
    }
    public boolean search(int key) {
        int index = hash(key);
        int i = 1;
        while (table[index] != -1) {
            if (table[index] == key) {
                return true;
            }
            index = (index + i * i) % table.length; // Quadratic probing
            i++;
        }
        return false;
    }

    public boolean delete(int key) {
        int index = hash(key);
        int i = 1;
        while (table[index] != -1) {
            if (table[index] == key) {
                table[index] = -1; // Mark as deleted
                size--;
                return true;
            }
            index = (index + i * i) % table.length; // Quadratic probing
            i++;
        }
        return false;
    }

    public void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < table.length; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }
}

class DoubleHashingHashTable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int PRIME_CONSTANT = 7;

    private Integer[] table;
    private int size;

    public DoubleHashingHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public DoubleHashingHashTable(int capacity) {
        table = new Integer[capacity];
        Arrays.fill(table, null); // Initialize all slots to null (indicating empty)
        size = 0;
    }

    private int hash1(int key) {
        return key % table.length;
    }

    private int hash2(int key) {
        return PRIME_CONSTANT - (key % PRIME_CONSTANT);
    }

    public void insert(int key) {
        if (size == table.length) {
            System.out.println("Hash table is full, cannot insert more elements.");
            return;
        }

        int index = hash1(key);
        int stepSize = hash2(key);

        while (table[index] != null) {
            index = (index + stepSize) % table.length; // Double hashing
        }

        table[index] = key;
        size++;
    }

    public boolean search(int key) {
        int index = hash1(key);
        int stepSize = hash2(key);

        while (table[index] != null) {
            if (table[index] == key) {
                return true; // Key found
            }
            index = (index + stepSize) % table.length; // Double hashing
        }

        return false; // Key not found
    }

    public boolean delete(int key) {
        int index = hash1(key);
        int stepSize = hash2(key);

        while (table[index] != null) {
            if (table[index] == key) {
                table[index] = null; // Mark as deleted
                size--;
                return true; // Key deleted
            }
            index = (index + stepSize) % table.length; // Double hashing
        }

        return false; // Key not found for deletion
    }

    public void display() {
        System.out.println("Hash Table (Double Hashing):");
        for (int i = 0; i < table.length; i++) {
            System.out.println("Index " + i + ": " + (table[i] != null ? table[i] : "null"));
        }
    }
}
public class ImplementationOfOpenAddressing {
    public static void main(String[] args) {
        //Linear Probing :
//        LinearProbing mh = new LinearProbing(7);
//        mh.insert(49);
//        mh.insert(56);
//        mh.insert(72);
//        if(mh.search(56))
//            System.out.println("Yes");
//        else
//            System.out.println("No");
//        mh.erase(56);
//        if(mh.search(56))
//            System.out.println("Yes");
//        else
//            System.out.println("No");
//        mh.display();

        //Quadratic Probing :
//        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(10);
//        hashTable.insert(15);
//        hashTable.insert(25);
//        hashTable.insert(35);
//        hashTable.insert(10);
//        hashTable.insert(20);
//        hashTable.display();
//        System.out.println("Search for key 25: " + hashTable.search(25));
//        System.out.println("Search for key 30: " + hashTable.search(30));
//
//        System.out.println("Deleting key 25: " + hashTable.delete(25));
//        System.out.println("Deleting key 30: " + hashTable.delete(30));
//        hashTable.display();

        //Double hashing 3
        DoubleHashingHashTable hashTable = new DoubleHashingHashTable(10);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(35);
        hashTable.insert(10);
        hashTable.insert(20);

        hashTable.display();

        System.out.println("Search for key 25: " + hashTable.search(25));
        System.out.println("Search for key 30: " + hashTable.search(30));

        System.out.println("Deleting key 25: " + hashTable.delete(25));
        System.out.println("Deleting key 30: " + hashTable.delete(30));

        hashTable.display();
    }
}
