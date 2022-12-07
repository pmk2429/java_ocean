package hard;

import java.util.*;

public class FirstKOccurringWords {

    private static List<String> findFirstKFrequentWords(String[] words, int k) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        Queue<String> wordsPriorityQueue = new PriorityQueue<>((w1, w2) -> wordMap.get(w1).equals(wordMap.get(w2))
            ? w1.compareTo(w2)
            : wordMap.get(w2) - wordMap.get(w1));

        for (String word : wordMap.keySet()) {
            wordsPriorityQueue.offer(word);
        }

        List<String> kOccurringWords = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            kOccurringWords.add(wordsPriorityQueue.poll());
        }

        return kOccurringWords;
    }

    public static void main(String[] args) {
        String[] dict =
            {
                "code", "coder", "coding", "codable", "codec", "codecs", "coded",
                "codeless", "codec", "codecs", "codependence", "codex", "codify",
                "codependents", "codes", "code", "coder", "codesign", "codec",
                "codeveloper", "codrive", "codec", "codecs", "codiscovered"
            };
        int k = 4;

        System.out.println(findFirstKFrequentWords(dict, k));
    }
}
