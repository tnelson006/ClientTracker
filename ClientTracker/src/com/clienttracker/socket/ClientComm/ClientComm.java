package com.clienttracker.socket.ClientComm;

/**
 *
 * @author T-Nel
 */
import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Counselor;
import com.clienttracker.model.domain.Note;
import com.clienttracker.socket.protocols.AddClientProtocol;
import com.clienttracker.socket.protocols.AddNoteProtocol;
import com.clienttracker.socket.protocols.DeleteClientProtocol;
import com.clienttracker.socket.protocols.DeleteNoteProtocol;
import com.clienttracker.socket.protocols.EditNoteProtocol;
import com.clienttracker.socket.protocols.InitializeClientTrackerProtocol;
import java.io.*;
import java.net.*;

public class ClientComm {

  Socket ccSocket;
  PrintWriter out;
  BufferedReader in;

  String hostName;
  int portNumber;

  public ClientComm(String hostName, int portNumber) {
    this.hostName = hostName;
    this.portNumber = portNumber;
  }

  private void enableSocket() {
    try {
      ccSocket = new Socket(hostName, portNumber);
      out = new PrintWriter(ccSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(ccSocket.getInputStream()));
    }
    catch (UnknownHostException e) {
      System.err.println("Don't know about host " + hostName);
    }
    catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " + hostName);
    }
  }

  private void closeSocket() {
    try {
      ccSocket.close();
    }
    catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to " + hostName);
    }
  }

  public void initializeClientTrackerComm(Counselor co) {
    enableSocket();
    System.out.println(co);
    InitializeClientTrackerProtocol ictp = new InitializeClientTrackerProtocol(co, out, in);
    ictp.executeProtocol();
    System.out.println(co);
    closeSocket();
  }

  public void addClientComm(Client client) {
    enableSocket();
    System.out.println(client);
    AddClientProtocol acp = new AddClientProtocol(client, out, in);
    acp.executeProtocol();
    System.out.println(client);
    closeSocket();
  }

  public void deleteClientComm(Client client) {
    enableSocket();
    System.out.println(client);
    DeleteClientProtocol dcp = new DeleteClientProtocol(client, out);
    dcp.executeProtocol();
    closeSocket();
  }

  public void addNoteComm(int clientID, Note note) {
    enableSocket();
    System.out.println(note);
    AddNoteProtocol anp = new AddNoteProtocol(clientID, note, out, in);
    anp.executeProtocol();
    System.out.println(note);
    closeSocket();
  }

  public void editNoteComm(int noteID, Note note) {
    enableSocket();
    System.out.println(note);
    EditNoteProtocol enp = new EditNoteProtocol(noteID, note, out);
    enp.executeProtocol();
    System.out.println(note);
    closeSocket();
  }

  public void deleteNoteComm(int noteID) {
    enableSocket();
    System.out.println(noteID);
    DeleteNoteProtocol enp = new DeleteNoteProtocol(noteID, out);
    enp.executeProtocol();
    System.out.println(noteID);
    closeSocket();
  }
}