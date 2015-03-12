package strings;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ParseString {
	public static void main(String[] args) {
		String entry = "Sheldon is very dedicated to his work but he also has outside interests and hobbies. "
				+ "Which of these is one of them?;"
				+ "http://dev.theappsdr.com/lectures/trivia/photos/Q2.jpg;"
				+ "Model trains;Line dancing;another answer;"
				+ "9";

		ArrayList<String> listAns = new ArrayList<String>();
		StringTokenizer str = new StringTokenizer(entry, ";");
		int noOfAnswers = str.countTokens() - 3;
		String question = str.nextToken();
		String imageUrl = str.nextToken();
		while (noOfAnswers > 0) {
			listAns.add(str.nextToken());
			noOfAnswers--;
		}
		int answer = Integer.parseInt(str.nextToken());

		System.out.println(question + "\n" + imageUrl + "\n"
				+ listAns.toString() + "\n" + answer);
	}
}
