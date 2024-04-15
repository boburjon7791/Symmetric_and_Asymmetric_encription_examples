package com.example.demo;

import java.lang.reflect.Constructor;

public interface AbstractEncryption<T> {
    T encrypt(String plainText);
    String decrypt(T encryptedText);
    static AbstractEncryption<byte[]> ofAsymmetric(){
        try {
            Class<AsymmetricEncryption> clazz = AsymmetricEncryption.class;
            Constructor<AsymmetricEncryption> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    static AbstractEncryption<String> ofSymmetric(){
        try {
            Class<SymmetricEncryption> clazz = SymmetricEncryption.class;
            Constructor<SymmetricEncryption> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
