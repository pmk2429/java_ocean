package strings;

public class StringTimeComplexity {
  public static void main(String[] args) {
    String[] words = {"Pavitra", "Mukund", "Kansara", "Komal", "Narendra",
        "Pancholi"};

    long startTime = System.currentTimeMillis();

    String stringSentence = new StringTimeComplexity()
        .makeSentenceString(words);

    long endTime = System.currentTimeMillis();

    long total = endTime - startTime;

    long startTime1 = System.currentTimeMillis();

    String stringBufferSentence = new StringTimeComplexity()
        .makeSentenceStringBuffer(words);

    long endTime1 = System.currentTimeMillis();

    long total1 = endTime1 - startTime1;

    System.out.println(stringSentence + " with String time: " + total
        + " ms");
    System.out.println(stringBufferSentence + " with String Buffer time: "
        + total1 + " ms");
  }

  public String makeSentenceString(String[] words) {

    String sentence = "";
    for (String s : words) {
      sentence = sentence + s;
    }
    return sentence;
  }

  public String makeSentenceStringBuffer(String[] words) {
    StringBuffer sentence = new StringBuffer();
    for (String s : words) {
      sentence.append(s);
    }
    return sentence.toString();
  }

}
