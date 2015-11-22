package misc;

public class FullName implements java.lang.Comparable {
	private String firstName = "Pavitra";
	private String lastName = "Kansara";
	
	public FullName(String first, String last){
		firstName = first;
		lastName = last;
	}
	
	public int compareTo(Object rhs){
		if(lastName.compareTo(((FullName)rhs).lastName) == 0){
			return firstName.compareTo(((FullName)rhs).firstName);
		}
		else{
			return lastName.compareTo(((FullName)rhs).lastName);
		}
	}
}
