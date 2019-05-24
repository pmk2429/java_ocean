package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * Example:
 * --------
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * Follow up:
 * ----------
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {

  private List<Integer> vals;

  private MedianFinder() {
    vals = new ArrayList<>();
  }

  private void addNum(int num) {
    vals.add(num);
  }

  private double findMedian() {
    int size = vals.size();
    double median;
    int middleIndex = (size - 1) / 2;
    if (size % 2 == 0) {
      median = (double) (vals.get(middleIndex) + vals.get(middleIndex + 1)) / 2;
    } else {
      median = vals.get(middleIndex);
    }
    return median;
  }

  // max queue is always larger or equal to min queue
  PriorityQueue<Integer> min = new PriorityQueue<>();
  PriorityQueue<Integer> max = new PriorityQueue<>(1000, Collections.reverseOrder());

  // Adds a number into the data structure.
  public void addNumPQ(int num) {
    max.offer(num);
    min.offer(max.poll());

    if (max.size() < min.size()) {
      max.offer(min.poll());
    }
  }

  // Returns the median of current data stream
  public double findMedianPQ() {
    if (max.size() == min.size()) {
      return (max.peek() + min.peek()) / 2.0;
    } else {
      return max.peek();
    }
  }

  /**
   * Your MedianFinder object will be instantiated and called as such:
   * MedianFinder obj = new MedianFinder();
   * obj.addNum(num);
   * double param_2 = obj.findMedian();
   */

  public static void main(String[] args) {
    MedianFinder m = new MedianFinder();
    m.addNum(1);
    m.addNum(2);
    System.out.println(m.findMedian());
    m.addNum(3);
    System.out.println(m.findMedian());
    m.addNum(4);
    System.out.println(m.findMedian());

    m.addNumPQ(1);
    m.addNumPQ(1);
    m.addNumPQ(1);
    System.out.println();
  }
}
