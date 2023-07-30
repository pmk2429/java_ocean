package hard;


import java.util.*;

/**
 * A Word Ladder is a sequence of dictionary words, where each word in the sequence differs from the
 * previous word by exactly one letter.
 * Given two starting words, determine the length of the shortest word ladder that connects the two.
 * Each word in the sequence must be in the English dictionary.
 * For example, given the words "COLD" and "WARM", a valid word ladder connecting the two would be:
 * --------
 * COLD -> CORD -> CARD -> WARD -> WARM (length = 5)
 * --------
 * FOOL to SAGE
 * FOOL -> POOL -> POLL -> POLE -> PALE -> SALE -> SAGE (length = 7)
 * <p>
 * ~!@#HARD:REVISE
 * ~!MyFav
 */
public class WordLadder {

    private static class WordObj {
        String word;
        int steps;
        List<String> neighbors; // separated by distance of 1 char delta

        public WordObj(String word, int steps, List<String> neighbors) {
            this.word = word;
            this.steps = steps;
            this.neighbors = neighbors;
        }

        public WordObj(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }

        public WordObj(String word, List<String> neighbors) {
            this.word = word;
            this.neighbors = neighbors;
        }

    }

    /**
     * BFS using Queue.
     * Determines the length of the shortest word ladder that connects the two based off Dictionary
     */
    private static List<String> wordLadder(String start, String target, Set<String> wordDict) {
        Deque<WordObj> wordQueue = new ArrayDeque<>();
        WordObj word = new WordObj(start, Collections.singletonList(start)); // start with first word
        wordQueue.add(word);

        // COLD --> CO_D --> _OLD
        // Loop
        // --- Lookup XX in the dictionary

        while (!wordQueue.isEmpty()) {
            WordObj currWord = wordQueue.poll();

            String startWord = currWord.word;
            List<String> allNeighbors = currWord.neighbors;

            // base case
            if (startWord.equals(target)) {
                // return totalSteps;
                return allNeighbors;
            }

            // startWordArr = C,O,L,D
            char[] wordArr = startWord.toCharArray();
            for (int i = 0; i < startWord.length(); i++) {
                // replace each char
                for (char c = 'A'; c < 'Z'; c++) {
                    char cTemp = wordArr[i];
                    if (wordArr[i] != c) {
                        wordArr[i] = c;
                    }

                    // COLD -> AOLD x -> backtrack -> if match -> getNeighbors OR -> remove from queue -> start with
                    // next character
                    // -> COLD -> AOLD -> BOLD -> DOLD -> EOLD
                    String tmpWord = new String(wordArr);
                    // if dict contains the new word then add it to Queue and do BFS on that word with count + 1
                    if (wordDict.contains(tmpWord)) {
                        List<String> tmpNeighbors = new ArrayList<>(allNeighbors);
                        tmpNeighbors.add(tmpWord);
                        //WordObj ladderWord = new WordObj(tmpWord, totalSteps + 1);
                        WordObj ladderWord = new WordObj(tmpWord, tmpNeighbors);
                        wordQueue.add(ladderWord);
                    }
                    // restore the character back in the word
                    wordArr[i] = cTemp;
                }
            }

            // COLD -> BOLD -> FOLD
            // WordObj(COLD, 1, [COLD])
            // WordObj(BOLD, 1, new ArrayList(initialTrack + BOLD))
        }
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        Set<String> englishDictionary = new HashSet<>(Arrays.asList("COLD", "BARD", "BALD", "CORD", "CARD", "WARD", "WARM", "BOLD", "FOOL", "POOL", "POLL", "POLE", "PALE", "SALE", "SAGE"));
        String start = "COLD";
        String end = "WARM";
        List<String> ladder = wordLadder(start, end, englishDictionary);
        System.out.println("1st :" + ladder);

        String start1 = "FOOL";
        String end1 = "SAGE";
        List<String> ladder2 = wordLadder(start1, end1, englishDictionary);
        System.out.println("2nd :" + ladder2);
    }
}
