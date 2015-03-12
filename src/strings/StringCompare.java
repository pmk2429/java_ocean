package strings;

public class StringCompare {
	public static void main(String[] args) {
		String s1 = new String("xyz");
		String s2 = "xyz";

		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
		System.out.println("\n----------------------\n");
		String s3 = s1;
		System.out.println(s1.equals(s3));
		System.out.println(s1 == s3);

		// System.out.println(15 % 10);
		// System.out.println(15 / 10);

	}
}
