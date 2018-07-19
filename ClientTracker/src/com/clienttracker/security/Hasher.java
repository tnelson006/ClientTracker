/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttracker.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author T-Nel
 */
public class Hasher {

  private static Hasher hasher = null;
  public static Hasher getHasher() {
    if(null == hasher) {
      hasher = new Hasher();
    }
    return hasher;
  }
  private Hasher() {}

  public String hashPasswordSHA512(String password) {
    String hashedPassword = "";
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      md.update(password.getBytes());
      hashedPassword = DatatypeConverter.printHexBinary(md.digest());
      System.out.println(hashedPassword);
    } catch(NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return hashedPassword;
  }
}
