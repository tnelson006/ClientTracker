package com.clienttracker.main;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Counselor;
import com.clienttracker.model.domain.Note;
import com.clienttracker.view.mainjframe.MainJFrame;
import com.clienttracker.view.mainjframe.MainJFrameController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import org.apache.log4j.Logger;

/**
 * This class contains the client side main function that will create and manage
 * various classes.
 *
 * @author Travis Nelson
 */
public class ClientTracker {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<Client> clients = new ArrayList<>();
    Counselor co = new Counselor(1, "Lauren", "Nelson", clients);

    List<Note> notes1 = new ArrayList<>();
    List<Note> notes2 = new ArrayList<>();
    Client cl1 = new Client("Herp", "Derpingson", notes1);
    Client cl2 = new Client("Derp", "Herpingson", notes2);

    Note n1 = new Note("Client exhibited strange behavior, but that is to be expected.");
    Note n2 = new Note("Client exhibited silly behavior, but that is to be expected.");
    Note n3 = new Note("Client exhibited odd behavior, but that is to be expected.");
    Note n4 = new Note("Client exhibited hilarious behavior, but that is to be expected.");

    cl1.addNote(n1);
    cl1.addNote(n2);
    cl2.addNote(n3);
    cl2.addNote(n4);

    co.addClient(cl1);
    co.addClient(cl2);

    MainJFrame mainJFrame = new MainJFrame();
    mainJFrame.setClients(co.getClients());

    @SuppressWarnings("unused")
		MainJFrameController mainJFrameController =
				new MainJFrameController(mainJFrame);
  }
}
