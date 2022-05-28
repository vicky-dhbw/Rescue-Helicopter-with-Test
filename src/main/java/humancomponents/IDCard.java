package humancomponents;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class IDCard {

    public final String personalNumber;

    private final String pin;

    private Date valid = new Date();

    public IDCard() {
        personalNumber = setPersonalNumber();
        pin = Integer.toString(new Random().nextInt(1000, 10000));            //pin as String containing int
        setKey(pin);

    }

    public static void setKey(String pin) {
        MessageDigest messageDigest;

        SecretKeySpec secretKey = null;
        try {
            byte[] key = pin.getBytes(StandardCharsets.UTF_8);
            messageDigest = MessageDigest.getInstance("SHA-1");
            key = messageDigest.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void setValidTill(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        valid = simpleDateFormat.parse(date);
    }

    public String setPersonalNumber() {
        char[] personalNumberChar = new char[5];
        char[] pool = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        String personalNumberString;

        int randomNum = new Random().nextInt(0, 10);
        char c = (char) (randomNum + '0');
        personalNumberChar[1] = c;


        for (int i = 0; i < 5; i++) {
            if (i == 1) {
                continue;
            }
            int randomAlpha = new Random().nextInt(0, 26);
            personalNumberChar[i] = pool[randomAlpha];
        }


        return String.valueOf(personalNumberChar);
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getPin() {
        return pin;
    }

    public Date getValid() {
        return valid;
    }
}
