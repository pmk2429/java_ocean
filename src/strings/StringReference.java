package strings;

public class StringReference {
	public static void main(String[] args) {
		String s1 = "I am String literal";
		String s2A = new String("I am String literal");
		String s2B = new String("I am String literal");
		String s3 = "India";
		String s4 = new String("India");
		String s5 = "India";
		System.out.println(s1 == s2A);
		System.out.println(s1.equals(s2A));
		String s1a = s1;
		System.out.println(s1a == s1);

		int a = 5;
		int b = 5;
		System.out.println(a == b);
	}

	// StringBuffer

	// StringBuilder

	// StringUtils
}
