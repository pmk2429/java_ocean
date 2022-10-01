package hard;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheO1 {
    private final LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCacheO1(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
