package practice;

public class SimpleExplain {
	public static void main(String[] args) {
		SimpleExplain simpleObj = new SimpleExplain();
		String url = simpleObj.getDesiredString(1);
		System.out.println(url);
	}

	public String getDesiredString(int num) {
		String url = "";

		if (num == 0) {
			url = "Num 0";
		}
		if (num == 1) {
			url = "Num 1";
		}

		if (num == 2) {
			url = "Num 2";
		}

		if (num == 3) {
			url = "Num 3";
		}

		if (num == 4) {
			url = "Num 4";
		}

		if (num == 5) {
			url = "Num 5";
		}
		if (num == 6) {
			url = "Num 6";
		}

		if (num == 7) {
			url = "Num 7";
		}

		String anotherUrl = getAnotherUrl(url);
		return anotherUrl;
	}

	private String getAnotherUrl(String url) {
		return url + ", Created by another URL ";
	}
}
