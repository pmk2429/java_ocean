package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator
 * that support the peek() operation -- it essentially peek() at the element that will be returned by the next
 * call to next().
 * <p>
 * Example 1:
 * ----------
 * Input
 * ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * Output
 * [null, 1, 2, 2, 3, false]
 * <p>
 * Explanation
 * -----------
 * PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
 * peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
 * peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
 * peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
 * peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
 * peekingIterator.hasNext(); // return False
 * <p>
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class PeekingIterator implements Iterator<Integer> {

    private Integer next;
    private Iterator<Integer> peekingIterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here;
        peekingIterator = iterator;
        next = null;
        if (peekingIterator.hasNext()) {
            next = peekingIterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (next == null) {
            return -1;
        }
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        /* As per the Java Iterator specs, we should throw a NoSuchElementException
         * if the next element doesn't exist. */
        if (next == null) {
            throw new NoSuchElementException();
        }
        Integer toReturn = next;
        next = null;
        if (peekingIterator.hasNext()) {
            next = peekingIterator.next();
        }
        return toReturn;
    }

    public static void main(String[] args) {

    }
}
