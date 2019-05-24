package character;

public class CharacterRead {

  String mainString;
  int counter = 0;

  public CharacterRead(String mainString) {
    this.mainString = mainString;
  }

  public String getMainString() {
    return mainString;
  }

  public void setMainString(String mainString) {
    this.mainString = mainString;
  }

  /**
   * <h1>read()</h1> A method that returns the next char for String every time
   * it is called for the same String object.
   *
   * <p>
   * It takes no argument and returns the first character of the String from
   * which it is called. Constructor is called upon by the calling class where
   * the character needs to be obtained. read() gets the next char of the
   * string passed as an argument in the constructor and returns it. read()
   * method checks for the characters of String until the length of the String
   * and when it encounters end of String, it sets the char to '\0' null
   * value. This null value is checked for while looping through the Strig
   * until its length.
   * </p>
   */
  public char read() {
    char indexedChar = '\0';
    if (this.mainString.equals(null)) {
      return '\0';
    }
    if (counter < mainString.length()) {
      indexedChar = mainString.charAt(counter);
      counter++;
    } else {
      indexedChar = '\0';
    }
    return indexedChar;
  }

  public static void main(String[] args) {
    CharacterRead cReadObj2 = new CharacterRead("pavitra kansara\nsfsu\nthank you");
    char temp;
    int wordCount = 0, charCount = 0, lineCount = 1;
    while ((temp = cReadObj2.read()) != '\0') {
      if (temp == ' ') {
        ++wordCount;
      } else if (temp == '\n') {
        ++lineCount;
        ++wordCount;
      }
      ++charCount;
    }
    System.out.println("Characters: " + charCount);
    System.out.println("Words: " + wordCount);
    System.out.println("Lines: " + lineCount);
  }
}
