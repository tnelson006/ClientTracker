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
public class NewUserProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  String availableUsername = "select username from Users where username = '%s'";
  String queryUsers = "insert into Users(username, hashedPassword, counselorID) values('%s', '%s', %s)";
  String queryCounselors = "insert into Counselors(firstName, lastName) values('%s', '%s')";

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

      Statement stmtAvailableUsers = conn.createStatement();
      ResultSet rsAvailableUsers = stmtAvailableUsers.executeQuery(String.format(availableUsername, username));

      //Indicate that the username is already taken
      if (rsAvailableUsers.next()) {
        System.out.println("Testing 1");
        out.println("-1");
      }

      Statement stmtCounselors = conn.createStatement();
      boolean success = stmtCounselors.execute(String.format(queryCounselors, firstName, lastName));
      System.out.println("success: " + success);

      int counselorID = -1;
      Statement stmtID = conn.createStatement();
      ResultSet rs = stmtID.executeQuery("SELECT LAST_INSERT_ID()");
      if (rs.next()) {
        System.out.println("Testing 1.5");
        counselorID = Integer.parseInt(rs.getString(1));
      } else {
        System.out.println("Testing 2");
        out.println("-1"); //Indicate an error to the client
      }

      Statement stmtUsers = conn.createStatement();
      System.out.println("Testing 3");
      stmtUsers.execute(String.format(queryUsers, username, hashedPassword, counselorID));
      System.out.println("Testing 4");

      out.println(Integer.toString(counselorID));

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
