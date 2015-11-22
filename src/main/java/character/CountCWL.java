package character;

public class CountCWL {
	public static void main(String[] args) {
		// test case 2
		CharacterRead cReadObj2 = new CharacterRead(
				"pavitra kansara\nsfsu\nthank you");
		char temp = '\0';
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
