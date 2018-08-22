package com.clienttrackerserver.socket.protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * InitializeClientTrackerProtocol sends all client data from database, for a
 * given user, to the client application to decrypt and display.
 */
public class InitializeClientTrackerProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  PreparedStatement queryCounselor;
  PreparedStatement queryClients;
  PreparedStatement queryNotes;

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

      this.queryCounselor = this.conn.prepareStatement("select firstName, lastName from Counselors where ID = ?");
      queryCounselor.setString(1, counselorID);
      ResultSet rsCounselor = queryCounselor.executeQuery();
      if(rsCounselor.next()){
        System.out.println("Counselor First Name: " + rsCounselor.getString(1));
        out.println(rsCounselor.getString(1));//Counselor First Name
        System.out.println("Counselor Last Name: " + rsCounselor.getString(2));
        out.println(rsCounselor.getString(2));//Counselor Last Name
      }

      this.queryClients = this.conn.prepareStatement("select * from Clients where counselorID = ?");
      queryClients.setString(1, counselorID);
      ResultSet rsClients = queryClients.executeQuery();
      while (rsClients.next()) {
        System.out.println("Object type: 1");
        out.println(1);//Signal that client info in inbound
        System.out.println("Client ID: " + rsClients.getString(1));
        out.println(rsClients.getString(1));//Client ID
        System.out.println("First Name: " + rsClients.getString(3));
        out.println(rsClients.getString(3));//First Name
        System.out.println("Last Name: " + rsClients.getString(4));
        out.println(rsClients.getString(4));//Last Name

        this.queryNotes = this.conn.prepareStatement("select * from Notes where clientID = ?");
        queryNotes.setString(1, rsClients.getString(1));
        ResultSet rsNotes = queryNotes.executeQuery();
        while (rsNotes.next()) {
          System.out.println("   Object type: 2");
          out.println(2);//Signal that note info in inbound
          System.out.println("   Note ID: " + rsNotes.getString(1));
          out.println(rsNotes.getString(1));//Note ID
          System.out.println("   First Name: " + rsNotes.getString(3));
          out.println(rsNotes.getString(3));//First Name
          System.out.println("   Last Name: " + rsNotes.getString(4));
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
        System.exit(1);
    }
  }
}
