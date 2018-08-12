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
public class AddNoteProtocol {

  PrintWriter out;
  BufferedReader in;
  Connection conn;
  PreparedStatement query;

  public AddNoteProtocol(PrintWriter out, BufferedReader in, Connection conn) {
    System.out.println("Instantiating AddNoteProtocol");
    this.out = out;
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String clientID, text, date;
    try {
      clientID = in.readLine();
      System.out.println(clientID);
      text = in.readLine();
      System.out.println(text);
      date = in.readLine();
      System.out.println(date);

      this.query = this.conn.prepareStatement("insert into Notes(clientID, text, date) values(?, ?, ?)");
      query.setString(1, clientID);
      query.setString(2, text);
      query.setString(3, date);
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
