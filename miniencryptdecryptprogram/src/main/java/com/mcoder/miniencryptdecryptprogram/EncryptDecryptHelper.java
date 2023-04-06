package com.mcoder.miniencryptdecryptprogram;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;



public class EncryptDecryptHelper {

    private static SecretKey secretKey;
    private static byte[] key;

    public static void setKey(String myKey){

        try {
            key = myKey.getBytes("UTF-8");

            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key,16);

            secretKey = new SecretKeySpec(key,"AES");

        }catch (NoSuchAlgorithmException e){


            System.out.println("Error"+e);

        }catch (UnsupportedEncodingException e){


            System.out.println("Error"+e);

        }

    }

    public static String encrypted(String strToEncrypt,String securityKey){

        try {
            setKey(securityKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

        }catch (Exception e){

            System.out.println("Encrypt Error"+e);
        }
        return null;
    }

    public static String decrypted(String strToDecrypt,String securityKey){

        try {
            setKey(securityKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }catch (Exception e){


            System.out.println("Decrypt Error"+e);

        }
        return null;
    }
}
