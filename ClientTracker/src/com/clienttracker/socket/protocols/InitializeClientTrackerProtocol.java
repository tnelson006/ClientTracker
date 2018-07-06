/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttracker.socket.protocols;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Counselor;
import com.clienttracker.model.domain.Note;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author T-Nel
 */
public class InitializeClientTrackerProtocol {

  private static final int INITIALIZECLIENTTRACKERPROTOCOL = 0;

  Counselor co;
  PrintWriter out;
  BufferedReader in;

  public InitializeClientTrackerProtocol(Counselor co, PrintWriter out, BufferedReader in) {
    this.co = co;
    this.out = out;
    this.in = in;
  }

  public void executeProtocol() {
    String fromClient;
    String fromServer;
    try {
      int clientID, noteID;
      String clientFirstName, clientLastName;
      String text;
      Date date;

      fromClient = Integer.toString(INITIALIZECLIENTTRACKERPROTOCOL);
      System.out.println("Client: " + fromClient);
      out.println(fromClient);

      System.out.println("Client: " + co.getUniqueID());
      out.println(co.getUniqueID());

      //Are there any client objects to create?
      fromServer = in.readLine();
      int objectType = Integer.parseInt(fromServer);

      while(objectType == 1){
        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        clientID = Integer.parseInt(fromServer);

        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        clientFirstName = fromServer;

        fromServer = in.readLine();
        System.out.println("Server: " + fromServer);
        clientLastName = fromServer;

        List<Note> notes = new ArrayList<>();

        //Are there any note objects to create?
        fromServer = in.readLine();
        objectType = Integer.parseInt(fromServer);

        while(objectType == 2){
          fromServer = in.readLine();
          System.out.println("Server: " + fromServer);
          noteID = Integer.parseInt(fromServer);

          fromServer = in.readLine();
          System.out.println("Server: " + fromServer);
          text = fromServer;

          fromServer = in.readLine();
          System.out.println("Server: " + fromServer);

          String pattern = "yyyy-MM-dd HH:mm:ss";
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
          date = simpleDateFormat.parse(fromServer);

          Note tempNote = new Note(text, date);
          tempNote.setNoteID(noteID);
          notes.add(tempNote);

          //Are there any more objects to create?
          fromServer = in.readLine();
          objectType = Integer.parseInt(fromServer);
        }
        Client tempClient = new Client(clientID, clientFirstName, clientLastName, notes);
        co.addClient(tempClient);
      }
    } catch (UnknownHostException e) {
        System.err.println("Don't know about host.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Couldn't get I/O for the connection.");
        System.exit(1);
    } catch (ParseException e) {
      System.err.println("Parsing from String to Date had an issue.");
      System.exit(1);
    }
  }
}
