package ru.gnkoshelev.j4net.sample.hash.lib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kgn on 13.03.2018.
 */
public class Hasher {
    private final static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String compute(String algorithm, byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(bytes);
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hex[v >>> 4];
            hexChars[j * 2 + 1] = hex[v & 0x0F];
        }
        return new String(hexChars);
    }
}
