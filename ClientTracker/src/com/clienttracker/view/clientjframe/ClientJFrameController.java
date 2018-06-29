package com.clienttracker.view.clientjframe;

import com.clienttracker.main.ClientTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.clienttracker.model.domain.Client;
import com.clienttracker.view.mainjframe.MainJFrameController;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;

/**
 * @author Travis Nelson
 *
 * This class handles all event listeners for the create client window and passes data
 * from the UI to other classes.
 */
public class ClientJFrameController implements ActionListener, KeyListener{

	private ClientJFrame clientJFrame;
  private MainJFrameController mainJFrameController;
  private boolean firstNameEmpty = true;
  private boolean lastNameEmpty = true;

	public ClientJFrameController(ClientJFrame clientJFrame, MainJFrameController mainJFrameController){

		this.clientJFrame = clientJFrame;
    this.mainJFrameController = mainJFrameController;

		clientJFrame.getCancelButton().addActionListener(this);
		clientJFrame.getSubmitClientButton().addActionListener(this);
    clientJFrame.getTextFieldFirstName().addKeyListener(this);
    clientJFrame.getTextFieldLastName().addKeyListener(this);

		clientJFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(clientJFrame.getCancelButton()))
			cancel_actionPerformed();
		else if(e.getSource().equals(clientJFrame.getSubmitClientButton()))
			submitClient_actionPerformed();
	}

  public void keyReleased(KeyEvent e){
    if (e.getSource().equals(clientJFrame.getTextFieldFirstName()))
      textChanged_actionPerformed(clientJFrame.getTextFieldFirstName());
    else if (e.getSource().equals(clientJFrame.getTextFieldLastName()))
      textChanged_actionPerformed(clientJFrame.getTextFieldLastName());
  }

  //Unused, but must be overridden
  public void keyPressed(KeyEvent e){
  }

  //Unused, but must be overridden
  public void keyTyped(KeyEvent e){
  }

	private void cancel_actionPerformed(){
		clientJFrame.dispose();
	}

	private void submitClient_actionPerformed(){

    Client newClient = clientJFrame.getEnteredData();
    ClientTracker.clientComm.addClientComm(newClient);

    mainJFrameController.addClient(newClient);

    clientJFrame.dispose();
	}

  private void textChanged_actionPerformed(javax.swing.JTextField jTextField){
		if(jTextField.equals(clientJFrame.getTextFieldFirstName())){
      firstNameEmpty = jTextField.getText().isEmpty();
    }
    else if(jTextField.equals(clientJFrame.getTextFieldLastName())){
      lastNameEmpty = jTextField.getText().isEmpty();
    }

    checkStatusOfSubmitButton();
	}

  private void checkStatusOfSubmitButton(){
    if(!firstNameEmpty && !lastNameEmpty){
      clientJFrame.setEnabledSubmitClientButton(true);
    }
    else{
      clientJFrame.setEnabledSubmitClientButton(false);
    }
  }
}