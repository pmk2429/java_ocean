package practice;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SetDemo {
	public static void main(String[] args) {
		Format formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
    	String today = formatter.format(new Date());
    	System.out.println("Today : " + today);
	}
}
