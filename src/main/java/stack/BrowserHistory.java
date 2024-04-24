package stack;

import java.util.Stack;

/**
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in
 * the history number of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * -----------------------------------
 * - BrowserHistory(String homepage) Initializes the object with the homepage of the browser.
 * - void visit(String url) Visits url from the current page. It clears up all the forward history.
 * - String back(int steps) Move steps back in history.
 * - If you can only return x steps in the history and steps > x, you will return only x steps.
 * - Return the current url after moving back in history at most steps.
 * - String forward(int steps) Move steps forward in history.
 * - If you can only forward x steps in the history and steps > x, you will forward only x steps.
 * - Return the current url after forwarding in history at most steps.
 * <p>
 * Example:
 * --------
 * Input:
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * Output:
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 * <p>
 * Explanation:
 * ------------
 * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
 * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
 * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
 * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
 * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
 * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
 * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
 * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
 * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
 * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 * <p>
 * Constraints:
 * ------------
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage and url consist of  '.' or lower case English letters.
 * At most 5000 calls will be made to visit, back, and forward.
 */
public class BrowserHistory {
    private final Stack<String> backStack;
    private final Stack<String> forwardStack;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        backStack.push(homepage);
    }

    /**
     * Everytime a user visits a new page, the forward Stack gets cleared.
     */
    public void visit(String url) {
        while (!forwardStack.isEmpty()) forwardStack.pop();
        backStack.push(url);
    }

    /**
     * We always keep the homepage as the last page in the stack and so while checking, the backstack
     * counter stops at > 1.
     */
    public String back(int steps) {
        while (backStack.size() > 1 && steps-- > 0) {
            forwardStack.push(backStack.peek());
            backStack.pop();
        }
        return backStack.peek();
    }


    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps-- > 0) {
            backStack.push(forwardStack.peek());
            forwardStack.pop();
        }
        return backStack.peek();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        String currentPage = "";
        browserHistory.visit("google.com");
        System.out.println("---> VISIT: google.com");
        browserHistory.visit("facebook.com");
        System.out.println("---> VISIT: facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println("---> VISIT: youtube.com");
        currentPage = browserHistory.back(1);
        System.out.println("---> BACK: " + currentPage);
        currentPage = browserHistory.back(1);
        System.out.println("---> BACK: " + currentPage);
        currentPage = browserHistory.forward(1);
        System.out.println("---> FORWARD: " + currentPage);
        browserHistory.visit("linkedin.com");
        System.out.println("---> VISIT: linkedin.com");
        System.out.println("--- Moving forward --- ");
        System.out.printf("--- Forward: %d, Back: %d --- ", browserHistory.forwardStack.size(), browserHistory.backStack.size());
        System.out.println();
        currentPage = browserHistory.forward(2);
        System.out.println("---> FORWARD: " + currentPage);
        currentPage = browserHistory.back(2);
        System.out.println("---> BACK: " + currentPage);
        currentPage = browserHistory.back(7);
        System.out.println("---> BACK: " + currentPage);
    }
}
