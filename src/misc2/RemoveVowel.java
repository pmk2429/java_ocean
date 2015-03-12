package misc2;

public class RemoveVowel {

	public static void main(String[] args) {
		String vowels = "aeiou";
		String test = new String("pavitra kansara is my name");

		for (int i = 0; i < test.length(); i++) {
			char ch = test.charAt(i);
			for (int j = 0; j < vowels.length(); j++) {
				if (ch == vowels.charAt(j)) {
					test = test.replace(ch, '_');
				}
			}
		}
		System.out.println(test);

	}
}
