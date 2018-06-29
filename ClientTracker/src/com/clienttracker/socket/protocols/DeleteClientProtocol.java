/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttracker.socket.protocols;

import com.clienttracker.main.ClientTracker;
import com.clienttracker.model.domain.Client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author T-Nel
 */
public class DeleteClientProtocol {

  private static final int DELETECLIENTPROTOCOL = 2;

  Client client;
  PrintWriter out;

  public DeleteClientProtocol(Client client, PrintWriter out) {
    this.client = client;
    this.out = out;
  }

  public void executeProtocol() {
    String fromClient;

      fromClient = Integer.toString(DELETECLIENTPROTOCOL);
      System.out.println("Client (protocol): " + fromClient);
      out.println(fromClient);

      fromClient = Integer.toString(ClientTracker.co.getUniqueID());
      System.out.println("Client (counselor ID): " + fromClient);
      out.println(fromClient);

      fromClient = client.getUniqueID().toString();
      System.out.println("Client (client ID): " + fromClient);
      out.println(fromClient);
  }
}
