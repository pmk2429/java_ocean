package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Design a wait list for customers at restaurant:
 * - Add customers to wait list (for example: Bob, party of 4 people)
 * - Remove a customer from wait list
 * - Given an open table with N seats, remove and return the first customer party of size N
 * <p>
 * Clarifications:
 * - 10 unique table sizes
 * - Customer names unique
 * - FIFO if two parties have the same number of people
 * - Table with N seats must have exactly N people
 * - Ideal solution O(1) runtime for all 3 methods
 */
public class RestaurantWaitList {
    private final Map<String, Integer> customerPartySizeMap;
    private final Deque<String> reservations; // customer wait list - stores name of people who made reservation
    private final Deque<String>[] tableQueues; // Array of queues for each table size

    public RestaurantWaitList(int maxTableSize) {
        customerPartySizeMap = new HashMap<>();
        reservations = new ArrayDeque<>();
        tableQueues = new ArrayDeque[maxTableSize + 1]; // 1-indexed array

        for (int i = 1; i <= maxTableSize; i++) {
            tableQueues[i] = new ArrayDeque<>();
        }
    }

    public void addCustomerToWaitList(String customerName, int partySize) {
        customerPartySizeMap.put(customerName, partySize);
        reservations.offer(customerName);
    }

    public boolean removeCustomerFromWaitList(String customerName) {
        if (customerPartySizeMap.containsKey(customerName)) {
            int partySize = customerPartySizeMap.get(customerName);
            reservations.remove(customerName);
            customerPartySizeMap.remove(customerName);
            tableQueues[partySize].remove(customerName);
            return true;
        }
        return false;
    }

    public String seatNextCustomer(int tableSize) {
        String customerName = null;
        if (tableSize < tableQueues.length && !tableQueues[tableSize].isEmpty()) {
            customerName = tableQueues[tableSize].poll();
        }
        removeCustomerFromWaitList(customerName);
        return customerName; // No suitable customer found for the table
    }

    public void addCustomerToTableQueue(String customerName) {
        int partySize = customerPartySizeMap.get(customerName);
        if (partySize < tableQueues.length) {
            tableQueues[partySize].offer(customerName);
        }
    }

    public static void main(String[] args) {
        RestaurantWaitList waitListObj = new RestaurantWaitList(10);

        waitListObj.addCustomerToWaitList("Alice", 3);
        waitListObj.addCustomerToWaitList("Bob", 4);
        waitListObj.addCustomerToWaitList("Charlie", 2);

        waitListObj.addCustomerToTableQueue("Alice");
        waitListObj.addCustomerToTableQueue("Bob");

        System.out.println("Seating next customer: " + waitListObj.seatNextCustomer(3));
        System.out.println("Seating next customer: " + waitListObj.seatNextCustomer(4));
    }
}
