package strings;

/**
 * Created by Pavitra on 12/23/2015.
 */
public class StaticMapDemo {
    public static void main(String[] args) {
        String url = new StaticMap.UrlBuilder().init().zoom(14).size(650, 350).path(40.737102, -73.990318)
                .path(40.749825, -73.987963).path(40.752946, -73.987384).path(40.755823, -73.986397).build();

        System.out.println(url);

        long time = 30;
        System.out.println(time + " mins");
    }
}
