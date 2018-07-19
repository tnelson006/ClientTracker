
package com.clienttracker.security;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author T-Nel
 */
public class Crypter {

  private Cipher decrypter = null;
  private Cipher encrypter = null;

  public Crypter(String password) {
    try {
      decrypter = Cipher.getInstance("AES/ECB/PKCS5Padding");
      encrypter = Cipher.getInstance("AES/ECB/PKCS5Padding");

      byte [] hashedPasswordKey = Hasher.getHasher().hashPasswordSHA256(password);
      SecretKeySpec skeySpec = new SecretKeySpec(hashedPasswordKey, "AES");

      encrypter.init(Cipher.ENCRYPT_MODE, skeySpec);
      decrypter.init(Cipher.DECRYPT_MODE, skeySpec);

    } catch(NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch(NoSuchPaddingException e) {
      e.printStackTrace();
    } catch(InvalidKeyException e) {
      e.printStackTrace();
    }
  }

  public String decrypt(String encrypted) {
        try {
            byte[] original = decrypter.doFinal(Base64.getDecoder().decode(encrypted));
            System.out.println("encrypted string: "
                    + Base64.getDecoder().decode(encrypted));
            System.out.println("decrypted string: "
                    + new String(original));
            return new String(original);
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        }

        return null;
    }

  public String encrypt(String unencrypted) {
        try {
            byte[] encrypted = encrypter.doFinal(unencrypted.getBytes());

            System.out.println("encrypted string: "
                    + Base64.getEncoder().encodeToString(encrypted));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
