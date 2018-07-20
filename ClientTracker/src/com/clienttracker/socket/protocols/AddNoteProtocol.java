package com.clienttracker.socket.protocols;

import com.clienttracker.model.domain.Note;
import com.clienttracker.security.Crypter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

/**
 *
 * @author T-Nel
 */
public class AddNoteProtocol {

  private static final int ADDNOTEPROTOCOL = 3;

  int clientID;
  Note note;
  Crypter crypter;
  PrintWriter out;
  BufferedReader in;

  public AddNoteProtocol(int clientID, Note note, Crypter crypter,
                         PrintWriter out, BufferedReader in) {
    this.clientID = clientID;
    this.note = note;
    this.crypter = crypter;
    this.out = out;
    this.in = in;
  }

  public void executeProtocol() {
    String fromClient;
    String fromServer;
    try {
      fromClient = Integer.toString(ADDNOTEPROTOCOL);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = Integer.toString(clientID);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = note.getText();
      System.out.println("Client: " + fromClient);
      out.println(crypter.encrypt(fromClient));

      String pattern = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

      fromClient = simpleDateFormat.format(note.getDate());
      System.out.println("Client: " + fromClient);
      out.println(crypter.encrypt(fromClient));

      if((fromServer = in.readLine()) != null){
          System.out.println("Server: " + fromServer);

          note.setNoteID(Integer.parseInt(fromServer));
    }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection.");
            System.exit(1);
        }
  }
}
