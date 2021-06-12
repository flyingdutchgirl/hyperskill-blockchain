package blockchain;

import java.security.MessageDigest;
import java.util.Objects;

public class StringUtil {
    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean startsWithZeros(String str, int howManyZeros) {
        if (howManyZeros == 0) {
            return true;
        }

        if (Objects.isNull(str)
                || str.length() < howManyZeros
                || str.length() == 0
                || howManyZeros < 0) {
            return false;
        }


        return str.substring(0, howManyZeros).matches("0+");
    }

}