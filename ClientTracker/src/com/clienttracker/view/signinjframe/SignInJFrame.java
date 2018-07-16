package com.clienttracker.view.signinjframe;

import java.awt.Dimension;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Note;
import java.util.ArrayList;

/**
 * @author Travis Nelson
 *
 * This class creates and displays all of the UI elements for the CreateClient window.
 */
public class SignInJFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 12345L;

	@SuppressWarnings("unused")
	private SignInJFrameController signInJFrameController;

	public SignInJFrame(){
		initComponents();

		this.signInJFrameController = new SignInJFrameController(this);

		this.setResizable(true);
		this.setMinimumSize(new Dimension(475, 225));
		this.setMaximumSize(new Dimension(475, 225));
		this.pack();
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void initComponents(){
		jButtonCancel = new javax.swing.JButton();
		jButtonSubmitLogin = new javax.swing.JButton();
    jButtonNewUser = new javax.swing.JButton();
		jLabelUsername = new javax.swing.JLabel();
		jLabelPassword = new javax.swing.JLabel();
		jPanel = new javax.swing.JPanel();
		jTextFieldUsername = new javax.swing.JTextField();
		jTextFieldPassword = new javax.swing.JTextField();

		setTitle("Client Tracker - Sign In");

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

		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonCancel.setText("Cancel");
		jPanel.add(jButtonCancel);
		jButtonCancel.setBounds(25, 125, 125, 50);

		jButtonSubmitLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonSubmitLogin.setText("Sign In");
    setEnabledSubmitLoginButton(false);
		jPanel.add(jButtonSubmitLogin);
		jButtonSubmitLogin.setBounds(175, 125, 125, 50);

    jButtonNewUser.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonNewUser.setText("New User");
		jPanel.add(jButtonNewUser);
		jButtonNewUser.setBounds(325, 125, 125, 50);

		getContentPane().add(jPanel);

		pack();
	}

  public javax.swing.JTextField getTextFieldUsername(){
		return jTextFieldUsername;
	}

  public javax.swing.JTextField getTextFieldPassword(){
		return jTextFieldPassword;
	}

	public javax.swing.JButton getCancelButton(){
		return jButtonCancel;
	}

  public javax.swing.JButton getSubmitLoginButton(){
		return jButtonSubmitLogin;
	}

  public javax.swing.JButton getNewUserButton(){
		return jButtonNewUser;
	}

  public void setEnabledSubmitLoginButton(boolean enabled){
		jButtonSubmitLogin.setEnabled(enabled);
	}

	private ArrayList<Note> notes;
  private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonSubmitLogin;
  private javax.swing.JButton jButtonNewUser;
	private javax.swing.JLabel jLabelUsername;
	private javax.swing.JLabel jLabelPassword;
	private javax.swing.JPanel jPanel;
	private javax.swing.JTextField jTextFieldUsername;
	private javax.swing.JTextField jTextFieldPassword;
}