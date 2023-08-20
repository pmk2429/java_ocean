package market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class MonkeyStockDataEntry {

    private final ArrayList<Integer> arr;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    // A hash where keys are array elements and values are indexes in arr[]
    private final HashMap<Integer, Integer> hash;

    // Constructor (creates arr[] and hash)
    public MonkeyStockDataEntry() {
        arr = new ArrayList<>();
        hash = new HashMap<>();
    }

    // A Theta(1) function to add an element to MonkeyStockDataEntry data structure
    void add(int x) {
        // If element is already present, then noting to do
        if (hash.get(x) != null) {
            return;
        }

        int lastIndex = arr.size();
        arr.add(x);
        hash.put(x, lastIndex);

        if (x > max) {
            max = x;
        }
        if (x < min) {
            min = x;
        }
    }

    // A Theta(1) function to remove an element from MyDS
    // data structure
    void remove(int x) {
        // Check if element is present
        Integer index = hash.get(x);
        if (index == null)
            return;

        // If present, then remove element from hash
        hash.remove(x);

        // Swap element with last element so that remove from
        // arr[] can be done in O(1) time
        int lastIndex = arr.size() - 1;
        Integer last = arr.get(lastIndex);
        Collections.swap(arr, index, lastIndex);

        // Remove last element (This is O(1))
        arr.remove(lastIndex);

        // Update hash table for new index of last element
        hash.put(last, index);
    }

    // Returns a random element from MonkeyStockDataEntry
    int getRandom() {
        Random rand = new Random();  // Choose a different seed
        int index = rand.nextInt(arr.size());
        return arr.get(index);
    }

    // Returns index of element if element is present, otherwise null
    Integer search(int x) {
        return hash.get(x);
    }

    public static void main(String[] args) {
        MonkeyStockDataEntry ds = new MonkeyStockDataEntry();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
    }
}
