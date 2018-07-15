package com.clienttracker.view.signinjframe;

import com.clienttracker.main.ClientTracker;
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
		this.setMinimumSize(new Dimension(450, 225));
		this.setMaximumSize(new Dimension(450, 225));
		this.pack();
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void initComponents(){
		jButtonCancel = new javax.swing.JButton();
		jButtonSubmitLogin = new javax.swing.JButton();
		jLabelUsername = new javax.swing.JLabel();
		jLabelPassword = new javax.swing.JLabel();
		jPanel = new javax.swing.JPanel();
		jTextFieldFirstName = new javax.swing.JTextField();
		jTextFieldLastName = new javax.swing.JTextField();

		setTitle("Client Tracker - Sign In");

		jPanel.setBackground(new java.awt.Color(76, 239, 220));
		jPanel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.setLayout(null);

		jLabelUsername.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelUsername.setText("Username:");
		jPanel.add(jLabelUsername);
		jLabelUsername.setBounds(50, 25, 100, 25);

		jTextFieldFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldFirstName);
		jTextFieldFirstName.setBounds(150, 25, 200, 25);

		jLabelPassword.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelPassword.setText("Password:");
		jPanel.add(jLabelPassword);
		jLabelPassword.setBounds(50, 75, 100, 25);

		jTextFieldLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldLastName);
		jTextFieldLastName.setBounds(150, 75, 200, 25);

		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonCancel.setLabel("Cancel");
		jPanel.add(jButtonCancel);
		jButtonCancel.setBounds(25, 125, 150, 50);

		jButtonSubmitLogin.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonSubmitLogin.setLabel("Sign In");
    setEnabledSubmitLoginButton(false);
		jPanel.add(jButtonSubmitLogin);
		jButtonSubmitLogin.setBounds(225, 125, 150, 50);

		getContentPane().add(jPanel);

		pack();
	}

	public Client getEnteredData(){

		notes = new ArrayList<>();

		Client client = new Client(-1,
                  jTextFieldFirstName.getText(),
									jTextFieldLastName.getText(),
                  notes);
		return client;
	}

  public javax.swing.JTextField getTextFieldUsername(){
		return jTextFieldFirstName;
	}

  public javax.swing.JTextField getTextFieldPassword(){
		return jTextFieldLastName;
	}

	public javax.swing.JButton getCancelButton(){
		return jButtonCancel;
	}

  public javax.swing.JButton getSubmitLoginButton(){
		return jButtonSubmitLogin;
	}

  public void setEnabledSubmitLoginButton(boolean enabled){
		jButtonSubmitLogin.setEnabled(enabled);
	}

	private ArrayList<Note> notes;
  private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonSubmitLogin;
	private javax.swing.JLabel jLabelUsername;
	private javax.swing.JLabel jLabelPassword;
	private javax.swing.JPanel jPanel;
	private javax.swing.JTextField jTextFieldFirstName;
	private javax.swing.JTextField jTextFieldLastName;
}