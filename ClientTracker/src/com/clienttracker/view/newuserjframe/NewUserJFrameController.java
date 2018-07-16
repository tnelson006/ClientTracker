package com.clienttracker.view.newuserjframe;

import com.clienttracker.main.ClientTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * @author Travis Nelson
 *
 * This class handles all event listeners for the create client window and passes data
 * from the UI to other classes.
 */
public class NewUserJFrameController implements ActionListener, KeyListener{

	private NewUserJFrame newUserJFrame;
  private boolean usernameEmpty = true;
  private boolean passwordEmpty = true;
  private boolean confirmPasswordEmpty = true;
  private boolean firstNameEmpty = true;
  private boolean lastNameEmpty = true;

	public NewUserJFrameController(NewUserJFrame newUserJFrame){

		this.newUserJFrame = newUserJFrame;
    newUserJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		newUserJFrame.getCancelButton().addActionListener(this);
		newUserJFrame.getSubmitUserButton().addActionListener(this);
    newUserJFrame.getSignInButton().addActionListener(this);

    newUserJFrame.getTextFieldUsername().addKeyListener(this);
    newUserJFrame.getTextFieldPassword().addKeyListener(this);
    newUserJFrame.getTextFieldConfirmPassword().addKeyListener(this);
    newUserJFrame.getTextFieldFirstName().addKeyListener(this);
    newUserJFrame.getTextFieldLastName().addKeyListener(this);

		newUserJFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(newUserJFrame.getCancelButton()))
			cancel_actionPerformed();
		else if(e.getSource().equals(newUserJFrame.getSubmitUserButton()))
			submitUser_actionPerformed();
    else if(e.getSource().equals(newUserJFrame.getSignInButton()))
			signIn_actionPerformed();
	}

  public void keyReleased(KeyEvent e){
    if (e.getSource().equals(newUserJFrame.getTextFieldUsername()))
      textChanged_actionPerformed(newUserJFrame.getTextFieldUsername());
    else if (e.getSource().equals(newUserJFrame.getTextFieldPassword()))
      textChanged_actionPerformed(newUserJFrame.getTextFieldPassword());
    else if (e.getSource().equals(newUserJFrame.getTextFieldConfirmPassword()))
      textChanged_actionPerformed(newUserJFrame.getTextFieldConfirmPassword());
    else if (e.getSource().equals(newUserJFrame.getTextFieldFirstName()))
      textChanged_actionPerformed(newUserJFrame.getTextFieldFirstName());
    else if (e.getSource().equals(newUserJFrame.getTextFieldLastName()))
      textChanged_actionPerformed(newUserJFrame.getTextFieldLastName());
  }

  //Unused, but must be overridden
  public void keyPressed(KeyEvent e){
  }

  //Unused, but must be overridden
  public void keyTyped(KeyEvent e){
  }

	private void cancel_actionPerformed(){
		newUserJFrame.dispose();
    System.exit(0);
	}

	private void submitUser_actionPerformed(){

    String username = newUserJFrame.getTextFieldUsername().getText();
    String password = newUserJFrame.getTextFieldPassword().getText();
    String confirmPassword = newUserJFrame.getTextFieldConfirmPassword().getText();

    //If the passwords are unequal, give up and hope they do it right next time
    if(!password.equals(confirmPassword)) return;

    String firstName = newUserJFrame.getTextFieldFirstName().getText();
    String lastName = newUserJFrame.getTextFieldLastName().getText();
    int counselorID = ClientTracker.clientComm.newUserComm(username, password,
                                                           firstName, lastName);
    ClientTracker.setCounselorID(counselorID);
    newUserJFrame.dispose();
	}

  private void signIn_actionPerformed(){
    ClientTracker.displaySignIn();
    newUserJFrame.dispose();
  }

  private void textChanged_actionPerformed(javax.swing.JTextField jTextField){
		if(jTextField.equals(newUserJFrame.getTextFieldUsername())){
      usernameEmpty = jTextField.getText().isEmpty();
    }
    else if(jTextField.equals(newUserJFrame.getTextFieldPassword())){
      passwordEmpty = jTextField.getText().isEmpty();
    }
    else if(jTextField.equals(newUserJFrame.getTextFieldConfirmPassword())){
      confirmPasswordEmpty = jTextField.getText().isEmpty();
    }
    else if(jTextField.equals(newUserJFrame.getTextFieldFirstName())){
      firstNameEmpty = jTextField.getText().isEmpty();
    }
    else if(jTextField.equals(newUserJFrame.getTextFieldLastName())){
      lastNameEmpty = jTextField.getText().isEmpty();
    }

    checkStatusOfSubmitButton();
	}

  private void checkStatusOfSubmitButton(){
    if(!usernameEmpty && !passwordEmpty && !confirmPasswordEmpty
       && !firstNameEmpty && !lastNameEmpty){
      newUserJFrame.setEnabledSubmitUserButton(true);
    }
    else{
      newUserJFrame.setEnabledSubmitUserButton(false);
    }
  }
}