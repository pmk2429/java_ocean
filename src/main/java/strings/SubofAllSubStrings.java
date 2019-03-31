package strings;

/**
 * Sum of all substrings of a string representing a number | Set 1
 * Given a integer represented as a string, we need to get the sum of all possible substrings of this string.
 * <p>
 * Examples:
 * --------
 * Input  : num = “1234”
 * Output : 1670
 * Sum = 1 + 2 + 3 + 4 + 12 + 23 + 34 + 123 + 234 + 1234 = 1670
 * <p>
 * Input  : num = “421”
 * Output : 491
 * Sum = 4 + 2 + 1 + 42 + 21 + 421 = 491
 * <p>
 * Algorithm
 * ----------
 * sumofdigit[i]  =  (i+1)*num[i] + 10*sumofdigit[i-1]
 */
public class SubofAllSubStrings {

}
