package timeStamp;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Pavitra on 11/5/2015.
 */
public class CurrentTimeStamp {
    public static void main(String[] args) {
        long current = System.currentTimeMillis();
        System.out.println(current);
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date netDate = (new Date(current));
        sdf.format(netDate);
        System.out.println(netDate);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = new Date(current);
        Format format = new SimpleDateFormat("MM-dd-yy HH:mm:ss");
        String dateTime = format.format(date);
        System.out.println(dateTime);

        // Java 8 to get current timestamp in milliseconds (long)
        Instant instant = Instant.now();
        long timeStampMillis = instant.toEpochMilli();
        System.out.println(timeStampMillis);
        System.out.println(new Date().getTime());
    }
}
