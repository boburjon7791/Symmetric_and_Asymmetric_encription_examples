package com.example.demo;

public class Main {
    public static void main(String[] args) {
        String value="Hello world";
        System.out.println("value = " + value);
        AbstractEncryption<String> symmetric = AbstractEncryption.ofSymmetric();
        String encrypted = symmetric.encrypt(value);
        System.out.println("encrypted = " + encrypted);
        String decrypted = symmetric.decrypt(encrypted);
        System.out.println("decrypted = " + decrypted);
        System.out.println(" =========== ");
        AbstractEncryption<byte[]> asymmetric = AbstractEncryption.ofAsymmetric();
        byte[] encrypted1 = asymmetric.encrypt(value);
        System.out.println("encrypted1 = " + new String(encrypted1));
        String decrypted1 = asymmetric.decrypt(encrypted1);
        System.out.println("decrypted1 = " + decrypted1);
    }
}
