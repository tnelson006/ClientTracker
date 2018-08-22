package com.clienttrackerserver.socket.protocols;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * EditNoteProtocol edits an existing note in the database.
 */
public class EditNoteProtocol {

  BufferedReader in;
  Connection conn;
  PreparedStatement query;

  public EditNoteProtocol(BufferedReader in, Connection conn) {
    System.out.println("Instantiating EditNoteProtocol");
    this.in = in;
    this.conn = conn;
  }

  public void executeProtocol() {
    String noteID, text, date;
    try {
      noteID = in.readLine();
      System.out.println(noteID);
      text = in.readLine();
      System.out.println(text);
      date = in.readLine();
      System.out.println(date);

      this.query = this.conn.prepareStatement("UPDATE Notes SET text = ?, date = ? WHERE noteID = ?");
      query.setString(1, text);
      query.setString(2, date);
      query.setString(3, noteID);
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
