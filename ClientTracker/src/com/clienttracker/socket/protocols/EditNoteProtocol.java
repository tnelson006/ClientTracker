package com.clienttracker.socket.protocols;

import com.clienttracker.model.domain.Note;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

/**
 *
 * @author T-Nel
 */
public class EditNoteProtocol {

  private static final int EDITNOTEPROTOCOL = 4;

  int noteID;
  Note note;
  PrintWriter out;

  public EditNoteProtocol(int noteID, Note note, PrintWriter out) {
    this.noteID = noteID;
    this.note = note;
    this.out = out;
  }

  public void executeProtocol() {
    String fromClient;
    try {
      fromClient = Integer.toString(EDITNOTEPROTOCOL);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = Integer.toString(noteID);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      fromClient = note.getText();
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      String pattern = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

      fromClient = simpleDateFormat.format(note.getDate());
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      } catch (Exception e) {
          System.err.println("Generic error and such.");
          System.exit(1);
      }
  }
}
