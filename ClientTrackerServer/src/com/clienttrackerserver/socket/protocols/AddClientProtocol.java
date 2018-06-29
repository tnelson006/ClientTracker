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
public class AddClientProtocol {

  PrintWriter out;
  BufferedReader in;

  public AddClientProtocol(PrintWriter out, BufferedReader in) {
    this.out = out;
    this.in = in;
  }

  public void executeProtocol() {
    String counselorID, clientFirstName, clientLastName;
    try {
      counselorID = in.readLine();
      System.out.println(counselorID);
      clientFirstName = in.readLine();
      System.out.println(clientFirstName);
      clientLastName = in.readLine();
      System.out.println(clientLastName);

      out.println("1");

    } catch (UnknownHostException e) {
        System.err.println("Don't know about host.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Couldn't get I/O for the connection.");
        System.exit(1);
    }
  }
}
