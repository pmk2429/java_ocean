package practice;

import java.util.ArrayList;

public class Demo {
	static int counter;
	static Question questionObj;

	public static void main(String[] args) {
		ArrayList<Question> listQuestion = new ArrayList<Question>();

		listQuestion.add(new Question(1, "tyson"));
		listQuestion.add(new Question(2, "Ahmedabad"));
		listQuestion.add(new Question(3, "San Francisco"));
		listQuestion.add(new Question(4, "Love"));
		listQuestion.add(new Question(5, "NYC"));

		if (counter == 0) {
			Question question = listQuestion.get(counter);
			questionObj = listQuestion.get(2);
			System.out.println(question.toString());
			System.out.println(questionObj.toString());
		} else {
			System.out.println("null value in question");
		}

	}

}

class Question {

	int num;
	String answer;

	public Question(int num, String answer) {
		super();
		this.num = num;
		this.answer = answer;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [num=" + num + ", answer=" + answer + "]";
	}

}
