package com.clienttracker.view.newuserjframe;

import java.awt.Dimension;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Note;
import java.util.ArrayList;

/**
 * @author Travis Nelson
 *
 * This class creates and displays all of the UI elements for the CreateClient window.
 */
public class NewUserJFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 12345L;

	@SuppressWarnings("unused")
	private NewUserJFrameController newUserJFrameController;

	public NewUserJFrame(){
		initComponents();

		this.newUserJFrameController = new NewUserJFrameController(this);

		this.setResizable(true);
		this.setMinimumSize(new Dimension(475, 375));
		this.setMaximumSize(new Dimension(475, 375));
		this.pack();
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void initComponents(){
		jButtonCancel = new javax.swing.JButton();
		jButtonSubmitUser = new javax.swing.JButton();
    jButtonSignIn = new javax.swing.JButton();
		jLabelUsername = new javax.swing.JLabel();
		jLabelPassword = new javax.swing.JLabel();
    jLabelConfirmPassword = new javax.swing.JLabel();
    jLabelFirstName = new javax.swing.JLabel();
		jLabelLastName = new javax.swing.JLabel();
		jPanel = new javax.swing.JPanel();
		jTextFieldUsername = new javax.swing.JTextField();
		jTextFieldPassword = new javax.swing.JTextField();
    jTextFieldConfirmPassword = new javax.swing.JTextField();
		jTextFieldFirstName = new javax.swing.JTextField();
    jTextFieldLastName = new javax.swing.JTextField();

		setTitle("Client Tracker - New User");

		jPanel.setBackground(new java.awt.Color(76, 239, 220));
		jPanel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.setLayout(null);

		jLabelUsername.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelUsername.setText("Username:");
		jPanel.add(jLabelUsername);
		jLabelUsername.setBounds(50, 25, 100, 25);

		jTextFieldUsername.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldUsername);
		jTextFieldUsername.setBounds(150, 25, 200, 25);

		jLabelPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelPassword.setText("Password:");
		jPanel.add(jLabelPassword);
		jLabelPassword.setBounds(50, 75, 100, 25);

		jTextFieldPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldPassword);
		jTextFieldPassword.setBounds(150, 75, 200, 25);

    jLabelConfirmPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelConfirmPassword.setText("Confirm Password:");
		jPanel.add(jLabelConfirmPassword);
		jLabelConfirmPassword.setBounds(50, 125, 100, 25);

		jTextFieldConfirmPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldConfirmPassword);
		jTextFieldConfirmPassword.setBounds(150, 125, 200, 25);

    jLabelFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelFirstName.setText("First Name:");
		jPanel.add(jLabelFirstName);
		jLabelFirstName.setBounds(50, 175, 100, 25);

		jTextFieldFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldFirstName);
		jTextFieldFirstName.setBounds(150, 175, 200, 25);

    jLabelLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelLastName.setText("Last Name:");
		jPanel.add(jLabelLastName);
		jLabelLastName.setBounds(50, 225, 100, 25);

		jTextFieldLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldLastName);
		jTextFieldLastName.setBounds(150, 225, 200, 25);

		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonCancel.setText("Cancel");
		jPanel.add(jButtonCancel);
		jButtonCancel.setBounds(25, 275, 125, 50);

		jButtonSubmitUser.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonSubmitUser.setText("Create User");
    setEnabledSubmitUserButton(false);
		jPanel.add(jButtonSubmitUser);
		jButtonSubmitUser.setBounds(175, 275, 125, 50);

    jButtonSignIn.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonSignIn.setText("Sign In");
		jPanel.add(jButtonSignIn);
		jButtonSignIn.setBounds(325, 275, 125, 50);

		getContentPane().add(jPanel);

		pack();
	}

  public javax.swing.JTextField getTextFieldUsername(){
		return jTextFieldUsername;
	}

  public javax.swing.JTextField getTextFieldPassword(){
		return jTextFieldPassword;
	}

  public javax.swing.JTextField getTextFieldConfirmPassword(){
		return jTextFieldConfirmPassword;
	}

  public javax.swing.JTextField getTextFieldFirstName(){
		return jTextFieldFirstName;
	}

  public javax.swing.JTextField getTextFieldLastName(){
		return jTextFieldLastName;
	}

	public javax.swing.JButton getCancelButton(){
		return jButtonCancel;
	}

  public javax.swing.JButton getSubmitUserButton(){
		return jButtonSubmitUser;
	}

  public javax.swing.JButton getSignInButton(){
		return jButtonSignIn;
	}

  public void setEnabledSubmitUserButton(boolean enabled){
		jButtonSubmitUser.setEnabled(enabled);
	}

	private ArrayList<Note> notes;
  private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonSubmitUser;
  private javax.swing.JButton jButtonSignIn;
	private javax.swing.JLabel jLabelUsername;
	private javax.swing.JLabel jLabelPassword;
  private javax.swing.JLabel jLabelConfirmPassword;
  private javax.swing.JLabel jLabelFirstName;
  private javax.swing.JLabel jLabelLastName;
	private javax.swing.JPanel jPanel;
	private javax.swing.JTextField jTextFieldUsername;
	private javax.swing.JTextField jTextFieldPassword;
  private javax.swing.JTextField jTextFieldConfirmPassword;
  private javax.swing.JTextField jTextFieldFirstName;
	private javax.swing.JTextField jTextFieldLastName;
}