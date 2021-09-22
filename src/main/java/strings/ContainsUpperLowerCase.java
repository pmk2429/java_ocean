package strings;

public class ContainsUpperLowerCase {
    public static void main(String[] args) {

        String password = "PAvitra";

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());

        // This allows you to check
        if (!hasUppercase) System.out.println("Must have an uppercase Character");
        if (!hasLowercase) System.out.println("Must have a lowercase Character");
    /* Essentially, this works by checking if the String is equal to its entirely lowercase, or uppercase equivalent.If
    this is not true, then there must be at least one character that is uppercase or lowercase. */

        // As for your other conditions, these can be satisfied in a similar way
        boolean isAtLeast8 = password.length() >= 8;//Checks for at least 8 characters
        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");//Checks at least one char is not alpha numeric
        boolean noConditions = !(password.contains("AND") || password.contains("NOT")); // Check that it doesn't contain AND or NOT

    }
}
