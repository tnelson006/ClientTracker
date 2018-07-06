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
public class InitializeClientTrackerProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  String queryClients = "select * from Clients where counselorID = %s";
  String queryNotes = "select * from Notes where clientID = %s";

  public InitializeClientTrackerProtocol(PrintWriter out, BufferedReader in, Connection conn) {
    System.out.println("Instantiating InitializeClientTrackerProtocol");
    this.out = out;
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String counselorID;

    try {
      counselorID = in.readLine();
      System.out.println("Counselor ID: " + counselorID);

      Statement stmtClients = conn.createStatement();
      ResultSet rsClients = stmtClients.executeQuery(String.format(queryClients, counselorID));
      while (rsClients.next()) {
        System.out.println("Object type: 1");
        out.println(1);//Signal that client info in inbound
        System.out.println("Object type: " + rsClients.getString(1));
        out.println(rsClients.getString(1));//Client ID
        System.out.println("Object type: " + rsClients.getString(3));
        out.println(rsClients.getString(3));//First Name
        System.out.println("Object type: " + rsClients.getString(4));
        out.println(rsClients.getString(4));//Last Name

        Statement stmtNotes = conn.createStatement();
        ResultSet rsNotes = stmtNotes.executeQuery(String.format(queryNotes, rsClients.getString(1)));
        while (rsNotes.next()) {
          System.out.println("   Object type: 2");
          out.println(2);//Signal that note info in inbound
          System.out.println("   Object type: " + rsNotes.getString(1));
          out.println(rsNotes.getString(1));//Note ID
          System.out.println("   Object type: " + rsNotes.getString(3));
          out.println(rsNotes.getString(3));//First Name
          System.out.println("   Object type: " + rsNotes.getString(4));
          out.println(rsNotes.getString(4));//Last Name
        }
      }

      //Let the client side know that transmission is over
      System.out.println("Object type: -1");
      out.println("-1");

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
