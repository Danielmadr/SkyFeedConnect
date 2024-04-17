package com.Ada.SFCAuthenticator.util;
import java.security.SecureRandom;

public class SecurityKeyGenerator {

  public static void main(String[] args) {
    int keyLengthInBytes = 64; // 512 bits / 8 = 64 bytes
    String jwtSecret = generateRandomHexKey(keyLengthInBytes);
    System.out.println("Generated JWT Secret Key: " + jwtSecret);
  }

  public static String generateRandomHexKey(int keyLengthInBytes) {
    SecureRandom secureRandom = new SecureRandom();
    byte[] key = new byte[keyLengthInBytes];
    secureRandom.nextBytes(key);
    return bytesToHex(key);
  }

  public static String bytesToHex(byte[] bytes) {
    StringBuilder hexString = new StringBuilder(2 * bytes.length);
    for (int i = 0; i < bytes.length; i++) {
      String hex = Integer.toHexString(0xff & bytes[i]);
      if (hex.length() == 1) {
        hexString.append('0');
      }
      hexString.append(hex);
    }
    return hexString.toString();
  }
}
