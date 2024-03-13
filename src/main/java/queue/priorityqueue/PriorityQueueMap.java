package queue.priorityqueue;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class PriorityQueueMap {
    public static void main(String[] args) {
        PriorityQueue<ItemEntry> pq = new PriorityQueue<>();
        pq.add(new ItemEntry("A", 40));
        pq.add(new ItemEntry("P", 24));
        pq.add(new ItemEntry("M", 48));
        pq.add(new ItemEntry("K", 24));
        pq.add(new ItemEntry("M", 20));
        System.out.println(pq.stream().findFirst());
    }
}

class ItemEntry implements Comparable<ItemEntry> {
    private String key;
    private int value;

    public ItemEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + " -> " + value;
    }

    @Override
    public int compareTo(@NotNull ItemEntry o) {
        // TODO: Compare with highest values and then if they are same, compareTo the keys
        return this.getKey().compareTo(o.getKey());
    }
}
