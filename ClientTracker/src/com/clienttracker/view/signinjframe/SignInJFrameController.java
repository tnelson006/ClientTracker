package com.clienttracker.view.signinjframe;

import com.clienttracker.main.ClientTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Travis Nelson
 *
 * This class handles all event listeners for the create client window and passes data
 * from the UI to other classes.
 */
public class SignInJFrameController implements ActionListener, KeyListener{

	private SignInJFrame signInJFrame;
  private boolean usernameEmpty = true;
  private boolean passwordEmpty = true;

	public SignInJFrameController(SignInJFrame signInJFrame){

		this.signInJFrame = signInJFrame;

		signInJFrame.getCancelButton().addActionListener(this);
		signInJFrame.getSubmitLoginButton().addActionListener(this);
    signInJFrame.getTextFieldUsername().addKeyListener(this);
    signInJFrame.getTextFieldPassword().addKeyListener(this);

		signInJFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(signInJFrame.getCancelButton()))
			cancel_actionPerformed();
		else if(e.getSource().equals(signInJFrame.getSubmitLoginButton()))
			submitLogin_actionPerformed();
	}

  public void keyReleased(KeyEvent e){
    if (e.getSource().equals(signInJFrame.getTextFieldUsername()))
      textChanged_actionPerformed(signInJFrame.getTextFieldUsername());
    else if (e.getSource().equals(signInJFrame.getTextFieldPassword()))
      textChanged_actionPerformed(signInJFrame.getTextFieldPassword());
  }

  //Unused, but must be overridden
  public void keyPressed(KeyEvent e){
  }

  //Unused, but must be overridden
  public void keyTyped(KeyEvent e){
  }

	private void cancel_actionPerformed(){
		signInJFrame.dispose();
    System.exit(0);
	}

	private void submitLogin_actionPerformed(){

    String username = signInJFrame.getTextFieldUsername().getText();
    String password = signInJFrame.getTextFieldPassword().getText();
    int counselorID = ClientTracker.clientComm.signInComm(username, password);
    ClientTracker.setCounselorID(counselorID);
    signInJFrame.dispose();
	}

  private void textChanged_actionPerformed(javax.swing.JTextField jTextField){
		if(jTextField.equals(signInJFrame.getTextFieldUsername())){
      usernameEmpty = jTextField.getText().isEmpty();
    }
    else if(jTextField.equals(signInJFrame.getTextFieldPassword())){
      passwordEmpty = jTextField.getText().isEmpty();
    }

    checkStatusOfSubmitButton();
	}

  private void checkStatusOfSubmitButton(){
    if(!usernameEmpty && !passwordEmpty){
      signInJFrame.setEnabledSubmitLoginButton(true);
    }
    else{
      signInJFrame.setEnabledSubmitLoginButton(false);
    }
  }
}