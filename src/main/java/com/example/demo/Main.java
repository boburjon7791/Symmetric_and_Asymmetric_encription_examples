package com.example.demo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.*;

public class Main {
    private static final String ALGORITHM="AES";
    private static final String ALGORITHM2="RSA";
    private static final String TRANSFORMATION="AES";
    public static void main(String[] args) {
        // symmetric encryption test
        /*final String key1="aesgrshtwafawaeg";
        String value="salom";
        System.out.println("value = " + value);
        String encrypt = encrypt(value, key1);
        System.out.println("encrypt = " + encrypt);
        String decrypt = decrypt(encrypt, key1);
        System.out.println("decrypt = " + decrypt);*/

        // asymmetric encryption test
        /*KeyPair keyPair = generateKeyPair();
        String data="Hello";
        System.out.println("data = " + data);
        byte[] encrypt = encrypt(data, keyPair.getPublic());
        StringBuilder sb=new StringBuilder();
        for (byte b : encrypt) {
            sb.append((char)b);
        }
        System.out.println("encrypt = " + sb);
        String decrypt = decrypt(encrypt, keyPair.getPrivate());
        System.out.println("decrypt = " + decrypt);*/
    }
    /**
     * It is symmetric encryption method example
     * */
    public static String encrypt(String plainText, String key){
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] plainTextBytes = plainText.getBytes();
            byte[] encrypted=cipher.doFinal(plainTextBytes);
            return Base64.getEncoder().encodeToString(encrypted);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * It is symmetric decryption method example
     * */
    public static String decrypt(String encryptedText, String key){
        try {
            Cipher cipher=Cipher.getInstance(TRANSFORMATION);
            SecretKeySpec secretKeySpec=new SecretKeySpec(key.getBytes(), ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] encryptedTextBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
            return new String(decryptedTextBytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
//    *********************************
    /**
     * It is key generation method example for asymmetric encryption
     * */
    public static KeyPair generateKeyPair(){
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM2);
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
    public static byte[] encrypt(String data, PublicKey key){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM2);
            cipher.init(Cipher.ENCRYPT_MODE,key);
            return cipher.doFinal(data.getBytes());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * It is asymmetric decryption method example
     * */
    public static String decrypt(byte[] encryptedData, PrivateKey key){
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM2);
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] decryptedBytes = cipher.doFinal(encryptedData);
            return new String(decryptedBytes);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
