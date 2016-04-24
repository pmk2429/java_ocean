package datetime;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class DateTime {
    public static void main(String[] args) {
//        int day, month, year;
//        int second, minute, hour;
//        GregorianCalendar date = new GregorianCalendar();
//
//        day = date.get(Calendar.DAY_OF_MONTH);
//        month = date.get(Calendar.MONTH);
//        year = date.get(Calendar.YEAR);
//
//        second = date.get(Calendar.SECOND);
//        minute = date.get(Calendar.MINUTE);
//        hour = date.get(Calendar.HOUR);
//
//        System.out.println("Current date is:  " + day + "/" + (month + 1) + "/"
//                + year);
//        System.out.println("Current time is:  " + hour + ":" + minute + ":"
//                + second);

        long timeStamp = 1451792189;
        Timestamp timestampObj = new Timestamp(timeStamp);
        long systemTimeStamp = System.currentTimeMillis();
        System.out.println("Sec timestamp: " + timeStamp);
        System.out.println("Millis timestamp: " + systemTimeStamp);
        Date date = new Date(systemTimeStamp);
        Format format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println(format.format(date));


        System.out.println("-----------------");
        long unixSeconds = 1451792189;
        Date againNew = new Date(unixSeconds * 1000L); // *1000 is to convert seconds to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss"); // the format of your date
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String formattedDate = sdf.format(againNew);
        System.out.println(formattedDate);


        System.out.println("-----------------");
        Date myDate = new Date(System.currentTimeMillis());
        Format dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);
        String dateTime = dateFormat.format(myDate);
        System.out.println(dateTime);
        String[] parts = dateTime.split(" ");
        System.out.println("Date: " + parts[0]);
        System.out.println("Time: " + parts[1]);

    }
}
