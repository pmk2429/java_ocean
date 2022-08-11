package hard;

/**
 * Suppose we have a class:
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * <p>
 * The same instance of Foo will be passed to three different threads.
 * Thread A will call first(), thread B will call second(), and thread C will call third().
 * Design a mechanism and modify the program to ensure that second() is executed after first(), and third()
 * is executed after second().
 * <p>
 * Example 1:
 * ----------
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(),
 * thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * <p>
 * Example 2:
 * ----------
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second().
 * "firstsecondthird" is the correct output.
 * <p>
 * Note:
 * -----
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input
 * seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 */
public class PrintInOrder {

    volatile int i = 0;

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 1;

    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (i != 1) ;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (i != 2) ;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        i = 3;
    }
}
