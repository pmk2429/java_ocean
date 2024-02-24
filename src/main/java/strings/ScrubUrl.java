package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given a URL that could contain sensitive data in the parameters, implement a way to scrub them
 * but include the length of the scrubbed data.
 * <p>
 * Keys of the sensitive data:
 * - access_token
 * - id_token
 * - api_key
 * - apikey
 * - username
 * - password
 * <p>
 * Example 1:
 * =========
 * Test cases:
 * Test case #1:
 * Input: https://example.com/path_of_url?access_token=123456
 * Output: https://example.com/path_of_url?access_token=****(length: 6)****
 * <p>
 * Test case #2:
 * Input: https://example.com/path_of_url?first_name=my_first_name&access_token=123456&last_name=my_last_name&api_key=abcde
 * Output: https://example.com/path_of_url?first_name=my_first_name&access_token=****(length: 6)****&last_name=my_last_name&api_key=****(length: 5)****
 * <p>
 * Test case #3:
 * Input: https://example.com/path_of_url?first_name=my_first_name&access_token=123456&last_name=my_last_name
 * Output: https://example.com/path_of_url?first_name=my_first_name&access_token=****(length: 6)****&last_name=my_last_name
 * <p>
 * Test case #4:
 * Input: https://example.com/path_of_url?first_name=my_first_name&access_token=123456&
 * Output: https://example.com/path_of_url?first_name=my_first_name&access_token=****(length: 6)****&
 **/

public class ScrubUrl {
    private static final String MORPH_KEYS = "****";
    private static final String QUERY_PARAM = "\\?";
    private static final String KEY_AMPERSAND = "\\&";

    private static Set<String> sensitiveDataKeys = new HashSet<String>() {{
        add("access_token");
        add("id_token");
        add("api_key");
        add("apikey");
        add("username");
        add("password");
    }};

    // access_token =  123456 --> access_token=****(length: 6)****
    private static String morphSensitiveData(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(MORPH_KEYS).append("(length: ").append(input.length()).append(")").append(MORPH_KEYS);
        return sb.toString();
    }

    // https://example.com/path_of_url?first_name=my_first_name&access_token=123456&last_name=my_last_name&api_key=abcde
    private static String scrub(String inputUrl) {
        StringBuilder result = new StringBuilder();

        // TODOs
        // null checks
        // empty checks
        // sanity checks
        // avoid redundancy


        boolean tailingAmpersand = inputUrl.substring(inputUrl.length() - 1).equals("&");
        String[] params = inputUrl.split(QUERY_PARAM);
        String baseUrl = params[0];
        result.append(baseUrl).append("?"); // baseUrl?...
        String queryParams = params[1];
        String[] tokens = queryParams.split(KEY_AMPERSAND);
        int tokenLength = tokens.length;
        int count = 0;
        for (String token : tokens) {
            count++;
            // access_token = 123456
            if (token != null && !token.isEmpty()) {
                String[] values = token.split("=");
                // match found
                String keyStr = values[0];
                String valueStr = values[1];
                if (sensitiveDataKeys.contains(keyStr)) {
                    valueStr = morphSensitiveData(valueStr);
                }
                result.append(keyStr).append("=").append(valueStr);
                if (count != tokenLength) {
                    result.append("&"); // baseUrl?access_token=123456 --> access_token=****(length: 6)****
                }
                if (tailingAmpersand) {
                    result.append("&");
                }
            }

        }

        return result.toString();
    }


    public static void main(String[] args) {
        String inputUrl1 = "https://example.com/path_of_url?access_token=123456";
        String outpurUrl1 = scrub(inputUrl1);
        System.out.println(outpurUrl1);

        // Test Case 2
        String inputUrl2 = "https://example.com/path_of_url?first_name=my_first_name&access_token=123456&last_name=my_last_name&api_key=abcde";
        String outpurUrl2 = scrub(inputUrl2);
        System.out.println(outpurUrl2);

        // Test Case 3
        String inputUrl3 = "https://example.com/path_of_url?first_name=my_first_name&access_token=123456&last_name=my_last_name";
        String outpurUrl3 = scrub(inputUrl3);
        System.out.println(outpurUrl3);

        // Test Case 4
        String inputUrl4 = "https://example.com/path_of_url?first_name=my_first_name&access_token=123456&";
        String outpurUrl4 = scrub(inputUrl4);
        System.out.println(outpurUrl4);
    }
}
