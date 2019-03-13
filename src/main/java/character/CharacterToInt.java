package character;

public class CharacterToInt {
  public static void main(String[] args) {
    char c = 'A';
    int data = c - '0';
    int ascii = (int) c;
    System.out.println("Numeric Value - " + data);
    System.out.println("Ascii Value - " + ascii);
  }
}
