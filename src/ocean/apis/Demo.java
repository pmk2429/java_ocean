package ocean.apis;

import encoding.*;

public class Demo {
	public static void main(String[] args) {
		BinaryText btObj = new BinaryText();
		
		String binary = btObj.convertTextToBinary("PMK");
		System.out.println(binary);
	}
}
