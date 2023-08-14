package strings;

public class StringTimeComplexity {
    public static void main(String[] args) {
        String[] words = {"Pavitra", "Mukund", "Kansara", "Komal", "Narendra", "Pancholi"};

        String stringSentence = new StringTimeComplexity().makeSentenceString(words);
        String stringBufferSentence = new StringTimeComplexity().makeSentenceStringBuffer(words);
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long total = endTime - startTime;
        long startTime1 = System.currentTimeMillis();

        long endTime1 = System.currentTimeMillis();
        long total1 = endTime1 - startTime1;

        System.out.println(stringSentence + " with String time: " + total + " ms");
        System.out.println(stringBufferSentence + " with String Buffer time: " + total1 + " ms");
    }

    public String makeSentenceString(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String s : words) {
            sentence.append(s);
        }
        return sentence.toString();
    }

    public String makeSentenceStringBuffer(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String s : words) {
            sentence.append(s);
        }
        return sentence.toString();
    }

}
