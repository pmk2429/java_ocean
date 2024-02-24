package statictypes;

import java.util.ArrayList;
import java.util.List;

public class ListStaticType {

    public static void main(String[] args) {
        List<Temp.LocationDetails> locations = new ListStaticType()
            .getLocations();

        for (Temp.LocationDetails location : locations) {
            System.out.println(location.toString());
        }

    }

    public List<Temp.LocationDetails> getLocations() {
        List<Temp.LocationDetails> locations = new ArrayList<Temp.LocationDetails>();
        locations.add(new Temp.LocationDetails(6.5, 5.9));
        locations.add(new Temp.LocationDetails(8559.55, 11.59));
        locations.add(new Temp.LocationDetails(87.222, -96.14422));

        return locations;
    }
}

class Temp {

    static class LocationDetails {

        double LAT, LONG;

        public LocationDetails(double lAT, double lONG) {
            super();
            LAT = lAT;
            LONG = lONG;
        }

        public double getLAT() {
            return LAT;
        }

        public double getLONG() {
            return LONG;
        }

        @Override
        public String toString() {
            return "LocationDetails [LAT=" + LAT + ", LONG=" + LONG + "]";
        }

    }

}
