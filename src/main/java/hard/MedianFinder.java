package hard;

import java.util.ArrayList;
import java.util.List;

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

  public MedianFinder() {
    vals = new ArrayList<>();
  }

  public void addNum(int num) {
    vals.add(num);
  }

  public double findMedian() {
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
  }
}
