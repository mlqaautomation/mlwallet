package KPX_WEB;

import org.jboss.aerogear.security.otp.Totp;
import static com.utility.Utilities.*;

public class TOTPGenerator {
    private static final yamlReader reader = new yamlReader();
    public static String getTwoFactorCode(){
        Totp totp = new Totp(reader.getAccessKey());
        return totp.now();
    }

}