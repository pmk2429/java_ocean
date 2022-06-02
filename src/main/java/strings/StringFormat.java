package strings;

public class StringFormat {
    public static void main(String[] args) {
        String a = "This is a long string";
        String c = "More on Purchase Protection";
        String demo = String.format(a + "\n%s", c);
        System.out.println(demo);
    }
}
