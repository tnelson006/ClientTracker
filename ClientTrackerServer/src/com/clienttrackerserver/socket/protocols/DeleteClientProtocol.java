/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttrackerserver.socket.protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;

/**
 *
 * @author T-Nel
 */
public class DeleteClientProtocol {

  BufferedReader in;

  public DeleteClientProtocol(BufferedReader in) {
    this.in = in;
  }

  public void executeProtocol() {
    String counselorID, clientID;
    try {
      counselorID = in.readLine();
      System.out.println(counselorID);
      clientID = in.readLine();
      System.out.println(clientID);

    } catch (UnknownHostException e) {
        System.err.println("Don't know about host.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Couldn't get I/O for the connection.");
        System.exit(1);
    }
  }
}
