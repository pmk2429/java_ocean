package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as
 * [https://leetcode.com/problems/design-tinyurl] and it returns a short URL
 * such as http://tinyurl.com/4e9iAk.
 * Design a class to encode a URL and decode a tiny URL.
 * <p>
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * <p>
 * Implement the Solution class:
 * <p>
 * Solution() Initializes the object of the system.
 * String encode(String longUrl) Returns a tiny URL for the given longUrl.
 * String decode(String shortUrl) Returns the original long URL for the given shortUrl.
 * It is guaranteed that the given shortUrl was encoded by the same object.
 * <p>
 * Example 1:
 * ==========
 * Input: url = "https://leetcode.com/problems/design-tinyurl"
 * Output: "https://leetcode.com/problems/design-tinyurl"
 * ==========
 * Explanation:
 * ==========
 * Solution obj = new Solution();
 * string tiny = obj.encode(url); // returns the encoded tiny url.
 * string ans = obj.decode(tiny); // returns the original url after deconding it.
 * <p>
 * Constraints:
 * ==========
 * 1 <= url.length <= 104
 * url is guranteed to be a valid URL.
 */
public class TinyUrl {
    private final static String BASE_HOST = "http://tinyurl.com/";

    private final Map<String, String> index = new HashMap<>();
    private final Map<String, String> revIndex = new HashMap<>();
    private final int URL_SHORTENER_LENGTH = 6;

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return index.get(shortUrl.replace(BASE_HOST, ""));
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (revIndex.containsKey(longUrl)) {
            return BASE_HOST + revIndex.get(longUrl);
        }

        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < URL_SHORTENER_LENGTH; i++) {
                int r = (int) (Math.random() * charSet.length());
                sb.append(charSet.charAt(r));
            }
            key = sb.toString();
        } while (index.containsKey(key));
        index.put(key, longUrl);
        revIndex.put(longUrl, key);
        return BASE_HOST + key;
    }

    public static void main(String[] args) {
        String url = "https://orifin.io";
        System.out.println("Original URL - " + url);
        TinyUrl tinyUrl = new TinyUrl();
        String encoded = tinyUrl.encode(url);
        System.out.println("Encoded - " + encoded);
        String decode = tinyUrl.decode(encoded);
        System.out.println("Decoded back - " + decode);
    }
}

