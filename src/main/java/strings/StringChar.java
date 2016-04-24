package strings;

/**
 * Created by Pavitra on 1/2/2016.
 */
public class StringChar {
    public static void main(String[] args) {
        String test = "file\"; filename=\"test.jpg\"";
        System.out.println(test);

        System.out.println(System.currentTimeMillis());

        System.out.println("ActivityId: " + "568b626113558dc50617c0ac".length());
        System.out.println("UserId: " + "568b626113558dc50617c0ac".length());

        String imageUrl = "http://www.google.com/image";
        if (imageUrl.startsWith("dcscdsd")) {
            System.out.println("yeah");
        } else {
            System.out.println("no");
        }
    }
}
