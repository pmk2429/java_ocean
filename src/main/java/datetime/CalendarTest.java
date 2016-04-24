package datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Pavitra on 12/2/2015.
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        Calendar someDate = Calendar.getInstance();
        someDate.set(Calendar.DAY_OF_MONTH, 15);
        someDate.set(Calendar.MONTH, 9); // 0-11 so 1 less
        someDate.set(Calendar.YEAR, 2015);

        Calendar then = Calendar.getInstance();
        then.set(Calendar.DAY_OF_MONTH, 5);
        then.set(Calendar.MONTH, 10); // 0-11 so 1 less
        then.set(Calendar.YEAR, 2016);

        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(someDate.getTime());
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(then.getTime());

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

        System.out.println("Diff: " + diffMonth + " : " + diffYear);

        int daysFinal = (diffMonth) * 30;
        System.out.println("Result : " + daysFinal);

        long diff = someDate.getTimeInMillis() - then.getTimeInMillis(); //result in millis
        int days = (int) diff / (24 * 60 * 60 * 1000);
        System.out.println(days);


        System.out.println("--------------------");
        int date = now.get(Calendar.DATE);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String expiryDate = "02/15/2016";


        try {

            Date dateObj = formatter.parse(expiryDate);
            Calendar expiry = Calendar.getInstance();
            expiry.setTime(dateObj);


            long difference = now.getTimeInMillis() - expiry.getTimeInMillis(); //result in millis
            int totalDays = (int) difference / (24 * 60 * 60 * 1000);
            //System.out.println(totalDays);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
