package com.example.demo;

public class Main {
    public static void main(String[] args) {
        String value="Hello world";
        System.out.println("value = " + value);
        System.out.println("Symmetric");

        AbstractEncryption<String> symmetric = AbstractEncryption.ofSymmetric();
        String encrypted = symmetric.encrypt(value);
        String decrypted = symmetric.decrypt(encrypted);



        System.out.println("encrypted = " + encrypted);
        System.out.println("decrypted = " + decrypted);

        System.out.println("=========== ");
        System.out.println("Asymmetric");

        AbstractEncryption<byte[]> asymmetric = AbstractEncryption.ofAsymmetric();
        byte[] encrypted1 = asymmetric.encrypt(value);
        String decrypted1 = asymmetric.decrypt(encrypted1);

        System.out.println("encrypted = " + new String(encrypted1));
        System.out.println("decrypted = " + decrypted1);
    }
}
