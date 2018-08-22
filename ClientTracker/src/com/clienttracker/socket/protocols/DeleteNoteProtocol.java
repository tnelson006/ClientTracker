package com.clienttracker.socket.protocols;

import java.io.PrintWriter;

/**
 * DeleteNoteProtocol sends the necessary information to the server to delete
 * an existing note.
 */
public class DeleteNoteProtocol {

  private static final int DELETENOTEPROTOCOL = 5;

  int noteID;
  PrintWriter out;

  public DeleteNoteProtocol(int noteID, PrintWriter out) {
    this.noteID = noteID;
    this.out = out;
  }

  public void executeProtocol() {
    String fromClient;
    try {
      fromClient = Integer.toString(DELETENOTEPROTOCOL);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = Integer.toString(noteID);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      } catch (Exception e) {
          System.err.println("Generic error and such.");
          System.exit(1);
      }
  }
}
