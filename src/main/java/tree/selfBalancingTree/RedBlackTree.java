package tree.selfBalancingTree;

import java.util.TreeSet;

public class RedBlackTree {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(24);
        numbers.add(25);
        numbers.add(26);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        int target = 25;

        Integer ceiling = numbers.ceiling(target);
        Integer floor = numbers.floor(target);
        Integer higher = numbers.higher(target);
        Integer lower = numbers.lower(target);

        System.out.println("Target: " + target);
        System.out.println("-----------");
        System.out.println("Ceiling: " + ceiling);
        System.out.println("Floor: " + floor);
        System.out.println("Higher: " + higher);
        System.out.println("Lower: " + lower);
    }
}
