package strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Pavitra on 1/20/2016.
 */
public class SetToDouble {
  public static void main(String[] args) {
    Set<String> latLngString = new HashSet<>();
    Set<LatLng> latLng = new HashSet<>();
    latLngString.add("19.545454,-74.5733222");
    latLngString.add("26.1553437,14.4733548");
    latLngString.add("48.1553437,-104.4733548");
    latLngString.add("37.7153437,-122.4733046");

    Iterator<String> iter = latLngString.iterator();
    while (iter.hasNext()) {
      String val = iter.next();
      String[] vals = val.split(",");
      latLng.add(new LatLng(Double.parseDouble(vals[0]), Double.parseDouble(vals[1])));
    }

    Iterator<LatLng> latLngIterator = latLng.iterator();
    while (latLngIterator.hasNext()) {
      System.out.println(latLngIterator.next().toString());
    }
  }
}

class LatLng {
  private double latitude, longitude;

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  @Override
  public String toString() {
    return latitude + " : " + longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public LatLng(double latitude, double longitude) {

    this.latitude = latitude;
    this.longitude = longitude;
  }
}