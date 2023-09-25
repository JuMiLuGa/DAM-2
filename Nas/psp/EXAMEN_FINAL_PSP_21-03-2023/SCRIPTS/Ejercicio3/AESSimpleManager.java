
package Ejercicio3;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


public class AESSimpleManager {
    public static Key obtenerClave (String password, int longitud){
        Key clave = new SecretKeySpec (password.getBytes(), 0, longitud, "AES");
        return clave;
    }
    
public static String cifrar (String textoEnClaro, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
    Cipher cipher = Cipher.getInstance("AES/ECB/PKCSPadding");
    cipher.init(Cipher.ENCRYPT_MODE,key);
    byte[] cipherText = cipher.doFinal(textoEnClaro.getBytes());
    
    return Base64.getEncoder().encodeToString(cipherText);
        
}

public static String descifrar (String textoCifrado, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
   return "";
        
}
    
    
}
