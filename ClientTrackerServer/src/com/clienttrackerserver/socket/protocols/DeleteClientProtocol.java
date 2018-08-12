/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttrackerserver.socket.protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author T-Nel
 */
public class DeleteClientProtocol {

  BufferedReader in;
  Connection conn;
  PreparedStatement query;

  public DeleteClientProtocol(BufferedReader in, Connection conn) {
    System.out.println("Instantiating DeleteClientProtocol");
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String clientID;
    try {
      clientID = in.readLine();
      System.out.println(clientID);

      this.query = this.conn.prepareStatement("delete from Clients where clientID = ?");
      query.setString(1, clientID);
      query.execute();

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
