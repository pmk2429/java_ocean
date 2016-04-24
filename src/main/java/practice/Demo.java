package practice;

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
