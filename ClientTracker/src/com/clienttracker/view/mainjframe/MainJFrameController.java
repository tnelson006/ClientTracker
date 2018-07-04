package com.clienttracker.view.mainjframe;

import com.clienttracker.main.ClientTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import com.clienttracker.model.business.manager.DAOManager;
import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Note;
import com.clienttracker.view.clientjframe.ClientJFrame;
import com.clienttracker.view.notejframe.NoteJFrame;
//import com.diagnosispro.model.services.factory.HibernateSessionFactory;
//import com.diagnosispro.view.addnotejframe.AddNoteJFrame;
//import com.diagnosispro.view.createclientjframe.CreateClientJFrame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author Travis Nelson
 *
 * This class handles all event listeners for the main window and passes data from the UI to other classes.
 */
public class MainJFrameController implements ActionListener{

	private static MainJFrame mainJFrame;
  final ArrayList<Note> emptyNotes = new ArrayList<Note>();

	public MainJFrameController(MainJFrame mainJFrame){
		this.mainJFrame = mainJFrame;

		mainJFrame.getFileMenuItemExit().addActionListener(this);
    mainJFrame.getAddClientButton().addActionListener(this);
    mainJFrame.getDeleteClientButton().addActionListener(this);
    mainJFrame.getAddNoteButton().addActionListener(this);
    mainJFrame.getEditNoteButton().addActionListener(this);
    mainJFrame.getDeleteNoteButton().addActionListener(this);
    addListeners();

		mainJFrame.setVisible(true);
	}

  public MainJFrame getMainJFrame(){
    return mainJFrame;
  }

  public void addListeners(){
    mainJFrame.getClientList().addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		          if (e.getValueIsAdjusting() == false){
		        	  if(mainJFrame.getClientListIndex()== -1){
		        		  mainJFrame.setEnabledDeleteClientButton(false);
		        		  mainJFrame.setEnabledAddNoteButton(false);
                  mainJFrame.setEnabledEditNoteButton(false);
		        		  mainJFrame.setEnabledDeleteNoteButton(false);
                  mainJFrame.setNotes(emptyNotes);
		        	  } else{
		        		  mainJFrame.setEnabledDeleteClientButton(true);
		        		  mainJFrame.setEnabledAddNoteButton(true);
                  mainJFrame.setEnabledEditNoteButton(true);
		        		  mainJFrame.setEnabledDeleteNoteButton(true);
                  ArrayList<Note> tempNotes = (ArrayList<Note>)((Client) mainJFrame.getClientListValue()).getNotes();
                  mainJFrame.setNotes(tempNotes);
		        	  }
		          }
		        }
		      });
  }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(mainJFrame.getAddClientButton()))
			addClient_actionPerformed();
    else if (e.getSource().equals(mainJFrame.getDeleteClientButton()))
			deleteClient_actionPerformed();
    else if (e.getSource().equals(mainJFrame.getAddNoteButton()))
			addNote_actionPerformed();
    else if (e.getSource().equals(mainJFrame.getEditNoteButton()))
			editNote_actionPerformed();
    else if (e.getSource().equals(mainJFrame.getDeleteNoteButton()))
			deleteNote_actionPerformed();
    else if (e.getSource().equals(mainJFrame.getFileMenuItemExit()))
			exit_actionPerformed();
	}

  private void addClient_actionPerformed() {
    System.out.println("addClient_actionPerformed");
    ClientJFrame clientJFrame = new ClientJFrame(this);
  }

  private void deleteClient_actionPerformed() {
    Client deleteClient = (Client)mainJFrame.getClientListValue();
    System.out.println("deleteClient_actionPerformed");
    System.out.println(deleteClient);

    ClientTracker.clientComm.deleteClientComm(deleteClient);

    deleteClient(deleteClient);
  }

	private void addNote_actionPerformed() {
    System.out.println("addNote_actionPerformed");
    NoteJFrame noteJFrame = new NoteJFrame(null, this);
	}

  private void editNote_actionPerformed() {
    System.out.println("editNote_actionPerformed");
    System.out.println(mainJFrame.getNoteListIndex());
    if(mainJFrame.getNoteListIndex() != -1) {
      Note selectedNote = (Note)mainJFrame.getNoteListValue();
      System.out.println(selectedNote);
      NoteJFrame noteJFrame = new NoteJFrame(selectedNote, this);
    }
	}

  private void deleteNote_actionPerformed() {
    System.out.println("deleteNote_actionPerformed");
    System.out.println(mainJFrame.getNoteListIndex());
    if(mainJFrame.getNoteListIndex() != -1) {
      System.out.println((Note)mainJFrame.getNoteListValue());
      deleteNote(mainJFrame.getNoteListIndex());
    }
	}

	private void exit_actionPerformed() {
		System.exit(0);
	}

  public void addClient(Client client) {
    ArrayList<Client> clients = mainJFrame.getClients();
    clients.add(client);
    mainJFrame.setClients(clients);
    addListeners();
  }

  public void deleteClient(Client client) {
    ArrayList<Client> clients = mainJFrame.getClients();
    clients.remove(client);
    mainJFrame.setClients(clients);
    addListeners();
  }

  public void addNote(Note note) {
    ArrayList<Client> clients = mainJFrame.getClients();
    int selectedClientIndex = mainJFrame.getClientListIndex();

    Client tempClient = clients.get(selectedClientIndex);
    tempClient.addNote(note);

    clients.set(selectedClientIndex, tempClient);
    mainJFrame.setClients(clients);
    mainJFrame.getClientList().setSelectedIndex(selectedClientIndex);

    mainJFrame.setNotes(tempClient.getNotes());

    addListeners();
  }

  public void editNote(Note note) {
    ArrayList<Client> clients = mainJFrame.getClients();
    int selectedClientIndex = mainJFrame.getClientListIndex();

    Client tempClient = clients.get(selectedClientIndex);
    List<Note> tempNotes = tempClient.getNotes();
    tempNotes.set(mainJFrame.getNoteListIndex(), note);
    tempClient.setNotes(tempNotes);

    clients.set(selectedClientIndex, tempClient);
    mainJFrame.setClients(clients);
    mainJFrame.getClientList().setSelectedIndex(selectedClientIndex);

    mainJFrame.setNotes(tempClient.getNotes());

    addListeners();
  }

  public void deleteNote(int noteIndex) {
    ArrayList<Client> clients = mainJFrame.getClients();
    int selectedClientIndex = mainJFrame.getClientListIndex();

    Client tempClient = clients.get(selectedClientIndex);
    List<Note> tempNotes = tempClient.getNotes();
    tempNotes.remove(noteIndex);
    tempClient.setNotes(tempNotes);

    clients.set(selectedClientIndex, tempClient);
    mainJFrame.setClients(clients);
    mainJFrame.getClientList().setSelectedIndex(selectedClientIndex);

    mainJFrame.setNotes(tempClient.getNotes());

    addListeners();
  }
}