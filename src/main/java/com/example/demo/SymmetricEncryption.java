package com.example.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.UUID;

public class SymmetricEncryption implements AbstractEncryption<String>{
    private static final String ALGORITHM="AES";
    private static final String TRANSFORMATION="AES";
    private final String key=generateKey();
    SymmetricEncryption(){}

    private String generateKey() {
        return UUID.randomUUID().toString().substring(0,16);
    }

    /**
     * It is symmetric encryption method example
     * */
    @Override
    public String encrypt(String plainText){
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] plainTextBytes = plainText.getBytes();
            byte[] encrypted=cipher.doFinal(plainTextBytes);
            return Base64.getEncoder().encodeToString(encrypted);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    /**
     * It is symmetric decryption method example
     * */
    @Override
    public String decrypt(String encryptedText){
        try {
            Cipher cipher=Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec secretKeySpec=new SecretKeySpec(key.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] encryptedTextBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
            return new String(decryptedTextBytes);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
