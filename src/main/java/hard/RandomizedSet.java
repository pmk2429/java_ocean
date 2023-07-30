package hard;

import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of
 * being returned.
 * <p>
 * Example:
 * --------
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class RandomizedSet {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        int newIndex = list.size();
        map.put(val, newIndex);
        list.add(newIndex, val);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // move the last element to the place idx of the element to delete
        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        int index = map.get(val);
        list.set(index, lastElement);
        map.put(lastElement, index);
        // delete the last element
        list.remove(lastIndex);
        map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        randomSet.insert(1);
        randomSet.remove(2);
        randomSet.insert(2);
        randomSet.getRandom();
        randomSet.remove(1);
        randomSet.insert(2);
        randomSet.getRandom();
    }
}
