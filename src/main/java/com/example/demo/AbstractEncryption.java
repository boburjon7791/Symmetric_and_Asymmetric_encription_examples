package com.example.demo;

public interface AbstractEncryption<T> {
    T encrypt(String plainText);
    String decrypt(T encryptedText);
    static AbstractEncryption<byte[]> ofAsymmetric(){
        return new AsymmetricEncryption();
    }
    static AbstractEncryption<String> ofSymmetric(){
        return new SymmetricEncryption();
    }
}
