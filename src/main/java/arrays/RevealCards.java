package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Reveal Cards In Increasing Order
 * ---------------------------------
 * In a deck of cards, every card has a unique integer. You can order the deck in any order you want.
 * Initially, all the cards start face down (unrevealed) in one deck.
 * Now, you do the following steps repeatedly, until all cards are revealed:
 * Take the top card of the deck, reveal it, and take it out of the deck.
 * If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
 * If there are still unrevealed cards, go back to step 1. Otherwise, stop.
 * Return an ordering of the deck that would reveal the cards in increasing order.
 * <p>
 * The first entry in the answer is considered to be the top of the deck.
 * <p>
 * Example 1:
 * ----------
 * Input: [17,13,11,2,3,5,7]
 * Output: [2,13,3,11,5,17,7]
 * Explanation:
 * We get the deck in the order [17,13,11,2,3,5,7] (this order doesn't matter), and reorder it.
 * After reordering, the deck starts as [2,13,3,11,5,17,7], where 2 is the top of the deck.
 * We reveal 2, and move 13 to the bottom.  The deck is now [3,11,5,17,7,13].
 * We reveal 3, and move 11 to the bottom.  The deck is now [5,17,7,13,11].
 * We reveal 5, and move 17 to the bottom.  The deck is now [7,13,11,17].
 * We reveal 7, and move 13 to the bottom.  The deck is now [11,17,13].
 * We reveal 11, and move 17 to the bottom.  The deck is now [13,17].
 * We reveal 13, and move 17 to the bottom.  The deck is now [17].
 * We reveal 17.
 * Since all the cards revealed are in increasing order, the answer is correct.
 * <p>
 * Note:
 * ----------
 * 1 <= A.length <= 1000
 * 1 <= A[i] <= 10^6
 * A[i] != A[j] for all i != j
 */
public class RevealCards {

    /**
     * Sorting Deck Algorithm:
     * -----------------------
     * 1. Sort the deck, it is actually the "final sequence" we want to get according to the question.
     * 2. Then put it back to the result array, we just need to deal with the index now!
     * 3. Simulate the process with a queue (initialized with 0,1,2...(n-1)), now how do we pick the card?
     * 4. We first pick the index at the top: res[q.poll()]=deck[i]
     * 5. Then we put the next index to the bottom: q.add(q.poll());
     * 6. Repeat it n times, and you will have the result array!
     */
    private static int[] deckRevealedIncreasing(int[] deck) {
        if (deck == null || deck.length == 0) {
            return null;
        }

        int N = deck.length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i);
        }
        int[] ans = new int[N]; // resultant array
        Arrays.sort(deck);

        for (int card : deck) {
            int index = queue.poll();
            ans[index] = card;
            // now add the pop the top of the queue and put it at the tail/back end.
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }

}
