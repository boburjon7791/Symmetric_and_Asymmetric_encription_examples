package com.example.demo;

import javax.crypto.Cipher;
import java.security.*;

public class AsymmetricEncryption implements AbstractEncryption<byte[]>{
    private static final String ALGORITHM="RSA";
    /**
     * It is key generation method example for asymmetric encryption
     * */
    private final KeyPair key=generateKey();
    private KeyPair generateKey(){
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
            generator.initialize(2048);
            return generator.generateKeyPair();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * It is asymmetric encryption method example
     * */
    public byte[] encrypt(String data){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,key.getPublic());
            return cipher.doFinal(data.getBytes());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * It is asymmetric decryption method example
     * */
    public String decrypt(byte[] encryptedText){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,key.getPrivate());
            byte[] decryptedBytes = cipher.doFinal(encryptedText);
            return new String(decryptedBytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
