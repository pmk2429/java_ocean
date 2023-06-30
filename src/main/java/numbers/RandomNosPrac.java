package numbers;

import java.util.*;

public class RandomNosPrac {
    public static void main(String args[]) {
        RandomNosPrac rdp = new RandomNosPrac();
        String cipherText = rdp.encipherText("pmk2429 is my name 24 I support 49ers");
        String plainText = rdp.decipherText(cipherText);
    }

    /**
     * Method to encrypt the Original Plain text in to a Cipher text.
     *
     * @param originalText
     * @return
     */
    private String encipherText(String originalText) {
        Random randomNo = new Random();
        String dirtyText = originalText;
        //String cipherText = "pmk0.X20.X40.X20.X943is67my23name540.X20.X432I72support70.X40.X9ers";
        String cleanText = "", emptyText = "", digitsText = "";
        int j;
        // emptyText = dirtyText.replaceAll("[1-9][0-9]*|0", " ");
        for (int i = 0; i < dirtyText.length(); i++) {
            if (Character.isDigit(dirtyText.charAt(i))) {
                digitsText = "0.X" + dirtyText.charAt(i);
                cleanText += digitsText;
            }
            if (Character.isWhitespace(dirtyText.charAt(i))) {
                j = randomNo.nextInt(100);
                emptyText = String.valueOf(j);
                cleanText += emptyText;
            }
            if (Character.isLetter(dirtyText.charAt(i))) {
                cleanText += dirtyText.charAt(i);
            }
        }
        System.out.println(cleanText);
        return cleanText;
    }

    /**
     * Method to DECIPHER the Cipher text in to original plain text.
     *
     * @param cipherText
     * @return
     */
    private String decipherText(String cipherText) {
        String dirtyText = cipherText;
        String plainText = "", unwantedText = "";
        char ch;
        for (int i = 0; i < dirtyText.length(); i++) {
            if (Character.isDigit(dirtyText.charAt(i))) {
                unwantedText += dirtyText.charAt(i);

            }
        }
        if (cipherText.contains("0.X")) {
            System.out.println(cipherText.indexOf("0.X"));
            System.out.println("Yes, its a cipher text");
        }
        return plainText;
    }
}