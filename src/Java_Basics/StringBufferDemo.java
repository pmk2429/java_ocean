package Java_Basics;

public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuffer strBuf = new StringBuffer("pavitra");
		strBuf.append(" kansara");
		StringBuffer str2 = strBuf;
		strBuf.replace(7, 7, " mukund ");
		System.out.println(str2);
		
		
	}

}
