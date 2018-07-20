/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttracker.socket.protocols;

import com.clienttracker.security.Crypter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author T-Nel
 */
public class NewUserProtocol {

  private static final int NEWUSERPROTOCOL = 7;

  private final String username;
  private final String hashedPassword;
  private final String firstName;
  private final String lastName;
  PrintWriter out;
  BufferedReader in;
  Crypter crypter;

  public NewUserProtocol(String username, String hashedPassword,
                         String firstName, String lastName,
                         PrintWriter out, BufferedReader in,
                         Crypter crypter) {
    this.username = username;
    this.hashedPassword = hashedPassword;
    this.firstName = firstName;
    this.lastName = lastName;
    this.out = out;
    this.in = in;
    this.crypter = crypter;
  }

  public int executeProtocol() {
    String fromClient;
    String fromServer;
    try {
      fromClient = Integer.toString(NEWUSERPROTOCOL);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      System.out.println("Client: " + username);
      out.println(username);

      System.out.println("Client: " + hashedPassword);
      out.println(hashedPassword);

      System.out.println("Client: " + firstName);
      out.println(crypter.encrypt(firstName));

      System.out.println("Client: " + lastName);
      out.println(crypter.encrypt(lastName));

      fromServer = in.readLine();
      System.out.println("Server: " + fromServer);

      //Did the server confirm this new user?
      int counselorID = Integer.parseInt(fromServer);
      if(counselorID != -1) return counselorID;
      else return -1;

    } catch (UnknownHostException e) {
         System.err.println("Don't know about host.");
         System.exit(1);
    } catch (IOException e) {
         System.err.println("Couldn't get I/O for the connection.");
         System.exit(1);
    }

    return -1;
  }
}
