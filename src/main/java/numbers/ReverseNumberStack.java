package numbers;

public class ReverseNumberStack {
	public static void main(String[] args) {
		String str = "pavitra", reverse = "";
		int size = str.length();
		Stack stackObj = new Stack(str.length());
		System.out.println("Original String: " + str);
		for (int i = 0; i < str.length(); i++) {
			stackObj.push(str.charAt(i));
		}
		System.out.print("Reversed String: ");
		for (int i = 0; i < size; i++) {
			reverse += stackObj.pop();
		}
		System.out.print(reverse);
	}
}

class Stack {
	char[] charArray;
	int top;
	int size;

	Stack(int size) {
		this.size = size;
		top = -1;
		charArray = new char[size];
	}

	public void push(char item) {
		if (top + 1 < size) {
			top++;
			this.charArray[top] = item;
		}
	}

	public char pop() {
		char data = 0;
		if (top >= 0) {
			data = charArray[top];
			top--;
		}
		return data;

	}

	public char peek() {
		return charArray[top];
	}
}