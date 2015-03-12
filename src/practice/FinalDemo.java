package practice;

public class FinalDemo {
	static String temp;

	public static void main(String[] args) {
		FinalDemo finalObj = new FinalDemo();
		temp = finalObj.demoMethod();
		System.out.println(temp);
	}

	public String demoMethod() {
		final String stringVar = "pavitra";
		String anotherString = stringVar;

		System.out.println("anotherString: " + anotherString);
		return anotherString;
	}
}
