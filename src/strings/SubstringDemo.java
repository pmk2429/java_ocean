package strings;

public class SubstringDemo {
	public static void main(String[] args) {
		String str = "18 Q0 categoryB.20051516 8 -4.86405 indri";
		String str2 = "18 Q0 categoryB.8132 10 -4.92462 indri";
		String subString = str.substring(16, 24);
		System.out.println(subString);
		String[] category = str2.split(" ");
		String categoryMain = category[2];
		System.out.println(categoryMain);
		String[] mainData = categoryMain.split("\\.");
		System.out.println(mainData[1]);
		

		String str1 = "1,categoryB.14302873";
		String keyMatch = str1.substring(2, str1.length());
		int key = Integer.parseInt(str1.substring(0, 1));
		System.out.println(keyMatch + " " + key);
	}
}
