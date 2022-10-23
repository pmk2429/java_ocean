package strings;

public class RotationString {
    private static boolean isRotation(String s1, String s2) {
        boolean rotation = false;
        if (s1.length() == s2.length() && s1.length() > 0) {
            String s1s1 = s1 + s1;
            if (s1s1.contains(s2)) {
                rotation = true;
            }
        }
        return rotation;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";
        if (isRotation(s1, s2)) {
            System.out.println("Yes, it is rotation");
        }
        else {
            System.out.println("No, Strings are not rotation");
        }

    }
}
