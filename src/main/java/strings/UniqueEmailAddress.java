package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Every email consists of a local name and a domain name, separated by the @ sign.
 * For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.
 * <p>
 * Besides lowercase letters, these emails may contain '.'s or '+'s.
 * <p>
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent
 * there will be forwarded to the same address without dots in the local name.
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * (Note that this rule does not apply for domain names.)
 * <p>
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
 * This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
 * (Again, this rule does not apply for domain names.) It is possible to use both of these rules at the same time.
 * <p>
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 * <p>
 * Example 1:
 * ----------
 * Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
 * Note:
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * Each emails[i] contains exactly one '@' character.
 */
public class UniqueEmailAddress {

    private static final String IGNORE = "+";
    private static final String PERIOD = ".";

    private static int uniqueEmailAddresses(String[] emails) {
        // rationale - to avoid adding duplicated
        Set<String> uniqueEmails = new HashSet<>();

        for (String s : emails) {
            StringBuilder sb = new StringBuilder();

            // split the email in to local name and domain name using @ symbol
            String[] metadata = s.split("@");
            String localName = metadata[0];
            String domainName = metadata[1];

            // check if localName contains period or ignore char
            if (localName.contains(PERIOD)) {
                localName = localName.replace(PERIOD, "");
            }

            if (localName.contains(IGNORE)) {
                int index = localName.indexOf(IGNORE);
                localName = localName.substring(0, index);
            }

            sb.append(localName).append("@").append(domainName);
            uniqueEmails.add(sb.toString());
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(uniqueEmailAddresses(emails));
    }
}
