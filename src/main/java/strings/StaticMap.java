package strings;

public class StaticMap {

    public static class UrlBuilder {

        private final boolean SENSOR = false;
        private final String MAP_TYPE = "roadmap";
        private final String STATIC_MAP_BASE_URL = "http://maps.googleapis.com/maps/api/staticmap?";
        private StringBuilder mapUrlBuilder = new StringBuilder();
        private StringBuilder pathBuilder = new StringBuilder();
        private final String AMPERSAND = "&";
        private final String COMMA = ",";
        private final String EQUALS = "=";
        private final String MULTIPLY = "x";
        private final String PIPE = "|";
        private int image_width;
        private int image_height;
        private int image_zoom;
        private int counter;
        private double point_lat, point_long;


        public UrlBuilder init() {
            mapUrlBuilder.append(STATIC_MAP_BASE_URL)
                .append("sensor").append(EQUALS).append(SENSOR).append(AMPERSAND)
                .append("maptype").append(EQUALS).append(MAP_TYPE);
            return this;
        }

        public UrlBuilder zoom(int zoom) {
            this.image_zoom = zoom;
            mapUrlBuilder.append(AMPERSAND).append("zoom").append(EQUALS).append(image_zoom);
            return this;
        }

        public UrlBuilder size(int height, int width) {
            this.image_height = height;
            this.image_width = width;
            if (mapUrlBuilder != null) {
                mapUrlBuilder.append(AMPERSAND).append("size").append(EQUALS).append(image_height).append(MULTIPLY).append
                    (image_width);
            }
            return this;
        }

        public UrlBuilder path(double latitude, double longitude) {
            this.point_lat = latitude;
            this.point_long = longitude;
            if (counter == 0) {
                pathBuilder.append(AMPERSAND).append("path").append(EQUALS).append(point_lat).append(COMMA).append(point_long);
            }
            else if (counter > 0) {
                pathBuilder.append(PIPE).append(point_lat).append(COMMA).append(point_long);
            }
            counter++;
            return this;
        }

        public String build() {
            return mapUrlBuilder.append(pathBuilder).toString();
        }
    }

    public static void main(String[] args) {
        String url = new StaticMap.UrlBuilder()
            .init()
            .zoom(14)
            .size(650, 350)
            .path(40.737102, -73.990318)
            .path(40.749825, -73.987963)
            .path(40.752946, -73.987384)
            .path(40.755823, -73.986397)
            .build();

        System.out.println(url);

        long time = 30;
        System.out.println(time + " mins");
    }
}