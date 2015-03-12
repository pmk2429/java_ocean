package strings;

public class MergeString {
	public static void main(String[] args) {
		String s1 = "pavitra";
		String s2 = "kansara";
		String sMain = s1.length() + s1 + s2;
		System.out.println("Merged String: " + sMain);
		String s1Original = sMain.substring(1, s1.length() + 1);
		System.out.println(s1Original);
		String s2Original = sMain.substring(s1.length() + 1, sMain.length());
		System.out.println(s2Original);
	}
}
