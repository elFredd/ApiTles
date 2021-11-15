/*
  Creado por "SCEN Solutions" para "SHIGRAS" Ecuador.
  Desarrollador: Ernesto Torres Ochoa 
  Date: 31/05/2019
  Time: 09:35 PM
  To change this template use File | Settings | File Templates.
*/

package controlador.core.AES;

import modelo.core.AES.AES;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class DesEncripAES implements AES {
    private Cipher cipher;
    public String  resultadoDesEncrip;
    public DesEncripAES(String CadenaDesEncriptar) {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            resultadoDesEncrip=  new String(cipher.doFinal(Base64.getDecoder().decode(CadenaDesEncriptar)), StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }

    }
    public DesEncripAES() {
        try
        {
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }

    }

    public String DesEncripAESMetodo(String CadenaDesEncriptar ){
        try {
            return  new String(cipher.doFinal(Base64.getDecoder().decode(CadenaDesEncriptar)), StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }

        return null;

    }
}
