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
public class NewUserProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  PreparedStatement availableUsername;
  PreparedStatement queryCounselors;
  PreparedStatement queryUsers;

  public NewUserProtocol(PrintWriter out, BufferedReader in, Connection conn) {
    System.out.println("Instantiating NewUserProtocol");
    this.out = out;
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String username, hashedPassword, firstName, lastName;
    try {
      username = in.readLine();
      System.out.println(username);
      hashedPassword = in.readLine();
      System.out.println(hashedPassword);
      firstName = in.readLine();
      System.out.println(firstName);
      lastName = in.readLine();
      System.out.println(lastName);

      this.availableUsername = this.conn.prepareStatement("select username from Users where username = ?");
      availableUsername.setString(1, username);
      ResultSet rsAvailableUsers = availableUsername.executeQuery();

      //Indicate that the username is already taken
      if (rsAvailableUsers.next()) {
        System.out.println("This username is already taken!");
        out.println("-1");
      }

      this.queryCounselors = this.conn.prepareStatement("insert into Counselors(firstName, lastName) values(?, ?)");
      queryCounselors.setString(1, firstName);
      queryCounselors.setString(2, lastName);
      boolean success = queryCounselors.execute();
      System.out.println("success: " + success);

      String counselorID = "-1";
      Statement stmtID = conn.createStatement();
      ResultSet rs = stmtID.executeQuery("SELECT LAST_INSERT_ID()");
      if (rs.next()) {
        System.out.println("Testing 1.5");
        counselorID = rs.getString(1);
      } else {
        System.out.println("Testing 2");
        out.println("-1"); //Indicate an error to the client
      }

      System.out.println("Testing 3");

      this.queryUsers = this.conn.prepareStatement("insert into Users(username, hashedPassword, counselorID) values(?, ?, ?)");
      queryUsers.setString(1, username);
      queryUsers.setString(2, hashedPassword);
      queryUsers.setString(3, counselorID);
      queryUsers.execute();

      System.out.println("Testing 4");

      out.println(counselorID);

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
