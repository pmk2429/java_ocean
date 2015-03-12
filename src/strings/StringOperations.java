package strings;

public class StringOperations {
	public static void main(String[] args) {
		System.out.println("Output for replaceAllChar(): "
				+ repalceAllChar("pavitra mukund kansara", "a", "*"));
		System.out.println("Output for deleteAllNonDigit(): "
				+ deleteAllNonDigit("#21sadfs23$&%^(!9@!"));
		System.out.println("Output for replaceCharAt(): "
				+ replaceCharAt("Amazon Google Apple Salesforce", 10, '$'));
		System.out.println("Output for removeChar(): "
				+ removeChar("Amazon Google Apple Salesforce", 'a'));
		System.out.println("Output for removeCharAt(): "
				+ removeCharAt("Amazon Google Apple Salesforce", 5));
	}

	private static String removeCharAt(String s, int i) {
		StringBuffer buf = new StringBuffer(s.length() - 1);
		buf.append(s.substring(0, i)).append(s.substring(i + 1));
		return buf.toString();
	}

	private static String removeChar(String s, char c) {
		StringBuffer buf = new StringBuffer(s.length());
		buf.setLength(s.length());
		int current = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (cur != c)
				buf.setCharAt(current++, cur);
		}
		return buf.toString();
	}

	private static String replaceCharAt(String s, int i, char c) {
		StringBuffer buf = new StringBuffer(s);
		buf.setCharAt(i, c);
		return buf.toString();
	}

	private static String deleteAllNonDigit(String s) {
		String temp = s.replaceAll("\\D", "");
		return temp;
	}

	public static String repalceAllChar(String s, String f, String r) {
		String temp = s.replace(f, r);
		return temp;
	}
}
