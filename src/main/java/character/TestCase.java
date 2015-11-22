package character;

public class TestCase {

	public static void main(String[] args) {
		// test case 1
		CharacterRead cReadObj = new CharacterRead("pavitra\nmukund\tkansara");
		char mainChar = '\0';
		while ((mainChar = cReadObj.read()) != '\0') {
			System.out.print(mainChar);
		}

	}

}
