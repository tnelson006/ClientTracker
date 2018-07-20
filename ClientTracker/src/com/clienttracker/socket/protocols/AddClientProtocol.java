/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttracker.socket.protocols;

import com.clienttracker.main.ClientTracker;
import com.clienttracker.model.domain.Client;
import com.clienttracker.security.Crypter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author T-Nel
 */
public class AddClientProtocol {

  private static final int ADDCLIENTPROTOCOL = 1;

  Client client;
  Crypter crypter;
  PrintWriter out;
  BufferedReader in;

  public AddClientProtocol(Client client, Crypter crypter,
                           PrintWriter out, BufferedReader in) {
    this.client = client;
    this.crypter = crypter;
    this.out = out;
    this.in = in;
  }

  public void executeProtocol() {
    String fromClient;
    String fromServer;
    try {
      fromClient = Integer.toString(ADDCLIENTPROTOCOL);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = Integer.toString(ClientTracker.co.getUniqueID());
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = client.getFirstName();
      System.out.println("Client: " + fromClient);
      out.println(crypter.encrypt(fromClient));

      fromClient = client.getLastName();
      System.out.println("Client: " + fromClient);
      out.println(crypter.encrypt(fromClient));

      if((fromServer = in.readLine()) != null){
          System.out.println("Server: " + fromServer);

          client.setUniqueID(Integer.parseInt(fromServer));
    }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection.");
            System.exit(1);
        }
  }
}
