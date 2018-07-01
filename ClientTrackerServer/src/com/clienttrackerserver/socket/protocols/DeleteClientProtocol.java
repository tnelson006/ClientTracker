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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author T-Nel
 */
public class DeleteClientProtocol {

  BufferedReader in;
  Connection conn;
  String query = "delete from Clients where counselorID = %s and clientID = %s";

  public DeleteClientProtocol(BufferedReader in, Connection conn) {
    System.out.println("Instantiating DeleteClientProtocol");
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String counselorID, clientID;
    try {
      counselorID = in.readLine();
      System.out.println(counselorID);
      clientID = in.readLine();
      System.out.println(clientID);

      Statement stmt = conn.createStatement();
      stmt.execute(String.format(query, counselorID, clientID));

    } catch (UnknownHostException e) {
        System.err.println("Don't know about host.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Couldn't get I/O for the connection.");
        System.exit(1);
    } catch (SQLException e) {
        System.err.println("Database bologna 1: ");
        e.printStackTrace();
        System.exit(-1);
    }
  }
}
