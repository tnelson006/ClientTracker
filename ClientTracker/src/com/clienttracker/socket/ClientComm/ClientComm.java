package com.clienttracker.socket.ClientComm;

/**
 *
 * @author T-Nel
 */
import com.clienttracker.model.domain.Client;
import com.clienttracker.socket.protocols.AddClientProtocol;
import com.clienttracker.socket.protocols.DeleteClientProtocol;
import java.io.*;
import java.net.*;

public class ClientComm {

  Socket ccSocket;
  PrintWriter out;
  BufferedReader in;

  String hostName;
  int portNumber;

  public ClientComm(String hostName, int portNumber) {
    this.hostName = hostName;
    this.portNumber = portNumber;
  }

  private void enableSocket() {
    try {
      ccSocket = new Socket(hostName, portNumber);
      out = new PrintWriter(ccSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(ccSocket.getInputStream()));
    }
    catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
    }
    catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " + hostName);
    }
  }

  private void closeSocket() {
    try {
      ccSocket.close();
    }
    catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " + hostName);
    }
  }

  public void addClientComm(Client client) {
    enableSocket();
    System.out.println(client);
    AddClientProtocol acp = new AddClientProtocol(client, out, in);
    acp.executeProtocol();
    System.out.println(client);
    closeSocket();
  }

  public void deleteClientComm(Client client) {
    enableSocket();
    System.out.println(client);
    DeleteClientProtocol dcp = new DeleteClientProtocol(client, out);
    dcp.executeProtocol();
    closeSocket();
  }
}