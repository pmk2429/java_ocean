package hard;

public class CreditCardValidation {

    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        // Remove any non-digit characters
        String cleanNumber = creditCardNumber.replaceAll("[^\\d]", "");

        // Check length
        if (cleanNumber.length() < 13 || cleanNumber.length() > 19) {
            return false;
        }

        // Check card type based on initial digits
        if (!isValidCardType(cleanNumber)) {
            return false;
        }

        // Apply Luhn algorithm (modulus 10)
        return luhnAlgorithmCheck(cleanNumber);
    }

    private static boolean isValidCardType(String creditCardNumber) {
        // Implement logic to check card type based on the initial digits
        // For simplicity, let's assume a card type based on the number of digits
        int length = creditCardNumber.length();
        if (length == 16) {
            System.out.println("Card type: Visa or MasterCard");
            return true;
        }
        else if (length == 15) {
            System.out.println("Card type: American Express");
            return true;
        }
        return false;
    }

    private static boolean luhnAlgorithmCheck(String creditCardNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(creditCardNumber.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = digit - 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        String visa = "4444444444444448";
        String master = "5500005555555559";
        String amex = "371449635398431";
        String diners = "36438936438936";
        String discover = "6011016011016011";
        String jcb = "3566003566003566";
        String luhnFail = "1111111111111111";

        String invalid = "abcdabcdabcdabcd";

        System.out.println(visa + " -> " + isValidCreditCardNumber(visa));
        System.out.println(master + " -> " + isValidCreditCardNumber(master));
        System.out.println(amex + " -> " + isValidCreditCardNumber(amex));
        System.out.println(diners + " -> " + isValidCreditCardNumber(diners));
        System.out.println(discover + " -> " + isValidCreditCardNumber(discover));
        System.out.println(jcb + " -> " + isValidCreditCardNumber(jcb));
        System.out.println(invalid + " -> " + isValidCreditCardNumber(invalid));
        System.out.println(luhnFail + " -> " + isValidCreditCardNumber(luhnFail));
    }
}
