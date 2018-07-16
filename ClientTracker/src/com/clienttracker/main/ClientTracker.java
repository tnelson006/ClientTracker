package com.clienttracker.main;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Counselor;
import com.clienttracker.socket.ClientComm.ClientComm;
import com.clienttracker.view.mainjframe.MainJFrame;
import com.clienttracker.view.mainjframe.MainJFrameController;
import com.clienttracker.view.newuserjframe.NewUserJFrame;
import com.clienttracker.view.signinjframe.SignInJFrame;
import java.util.ArrayList;

/**
 * This class contains the client side main function that will create and manage
 * various classes.
 *
 * @author Travis Nelson
 */
public class ClientTracker {

  public static ClientComm clientComm;
  public static Counselor co;
  private static ArrayList<Client> clients = new ArrayList<>();

  public static void main(String[] args) {
    co = new Counselor(-1, "tempFirstName", "tempLastName", clients);

    clientComm = new ClientComm("localhost", 8080);
    displaySignIn();
  }

  public static void setCounselorID(int ID) {
    co.setUniqueID(ID);
    System.out.println("The unique ID is: " + co.getUniqueID());
    displayMainWindow();
  }

  public static void displaySignIn() {
    SignInJFrame signInJFrame = new SignInJFrame();
  }

  public static void displayNewUser() {
    NewUserJFrame newUserJFrame = new NewUserJFrame();
  }

  private static void displayMainWindow() {
    clientComm.initializeClientTrackerComm(co);

    MainJFrame mainJFrame = new MainJFrame();
    mainJFrame.setClients(co.getClients());

    @SuppressWarnings("unused")
		MainJFrameController mainJFrameController =
				new MainJFrameController(mainJFrame);
  }
}
