package practice;

public class Q2 {
	public static void main(String[] args) {
		Q2 q2Obj = new Q2();
		StudentInternational student1 = q2Obj.new StudentInternational("Marc", "Mars");
		System.out.println(student1.toString());
	}

	abstract class Student {
		String name;

		public Student(String name) {
			this.name = name;
		}
	}

	class StudentInternational extends Student {
		String countryOfOrigin;

		StudentInternational(String name, String origin) {
			super(name);
			this.countryOfOrigin = origin;
		}

		public String toString() {
			return "Name: " + name + " from " + "Origin: " + countryOfOrigin;
		}
	}

}
