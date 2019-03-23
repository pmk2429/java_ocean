package strings;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeUrl {
  Map<String, String> map = new HashMap<>();

  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    String shortened = Integer.toHexString(longUrl.hashCode());
    map.put(shortened, longUrl);
    return shortened;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String longUrl = map.get(shortUrl);
    return longUrl;
  }
}
