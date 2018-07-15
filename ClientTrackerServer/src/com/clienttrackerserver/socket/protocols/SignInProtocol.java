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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author T-Nel
 */
public class SignInProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  String query = "select hashedPassword, counselorID from users where username = '%s'";

  public SignInProtocol(PrintWriter out, BufferedReader in, Connection conn) {
    System.out.println("Instantiating SignInProtocol");
    this.out = out;
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String username, hashedPassword;
    try {
      username = in.readLine();
      System.out.println(username);
      hashedPassword = in.readLine();
      System.out.println(hashedPassword);

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(String.format(query, username));

      //Was something returned from the query?
      if (rs.next()) {
        if (rs.getString(1).equals(hashedPassword)) {
          out.println(rs.getString(2));
        } else {
          out.println("-1"); //Indicate an error to the client
        }
      } else {
        out.println("-1"); //Indicate an error to the client
      }

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
