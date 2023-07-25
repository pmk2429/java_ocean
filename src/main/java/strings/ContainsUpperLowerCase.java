package strings;

public class ContainsUpperLowerCase {
    public static void main(String[] args) {

        String password = "PAvitra";

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());

        // This allows you to check
        if (!hasUppercase) System.out.println("Must have an uppercase Character");
        if (!hasLowercase) System.out.println("Must have a lowercase Character");
    }
}
