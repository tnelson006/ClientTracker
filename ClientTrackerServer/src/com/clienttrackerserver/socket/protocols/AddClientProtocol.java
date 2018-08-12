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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author T-Nel
 */
public class AddClientProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  PreparedStatement query;

  public AddClientProtocol(PrintWriter out, BufferedReader in, Connection conn) {
    System.out.println("Instantiating AddClientProtocol");
    this.out = out;
    this.in = in;
    this.conn = conn;
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

      this.query = this.conn.prepareStatement("insert into Clients(counselorID, firstName, lastName) values(?, ?, ?)");
      query.setString(1, counselorID);
      query.setString(2, clientFirstName);
      query.setString(3, clientLastName);
      query.execute();

      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
      if (rs.next()) {
        out.println(rs.getString(1));
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
