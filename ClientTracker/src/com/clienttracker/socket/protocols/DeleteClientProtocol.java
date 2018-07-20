
package com.clienttracker.socket.protocols;

import com.clienttracker.model.domain.Client;

import java.io.PrintWriter;

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

      fromClient = client.getUniqueID().toString();
      System.out.println("Client (client ID): " + fromClient);
      out.println(fromClient);
  }
}
