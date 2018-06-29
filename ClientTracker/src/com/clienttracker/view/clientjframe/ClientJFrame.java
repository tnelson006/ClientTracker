package com.clienttracker.view.clientjframe;

import java.awt.Dimension;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Note;
import com.clienttracker.view.mainjframe.MainJFrameController;
import java.util.ArrayList;

/**
 * @author Travis Nelson
 *
 * This class creates and displays all of the UI elements for the CreateClient window.
 */
public class ClientJFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 12345L;

	@SuppressWarnings("unused")
	private ClientJFrameController clientJFrameController;
  private MainJFrameController mainJFrameController;

	public ClientJFrame(MainJFrameController mainJFrameController){
		initComponents();

		this.clientJFrameController = new ClientJFrameController(this, mainJFrameController);
    this.mainJFrameController = mainJFrameController;

		this.setResizable(true);
		this.setMinimumSize(new Dimension(450, 225));
		this.setMaximumSize(new Dimension(450, 225));
		this.pack();
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void initComponents(){
		jButtonCancel = new javax.swing.JButton();
		jButtonSubmitClient = new javax.swing.JButton();
		jLabelFirstName = new javax.swing.JLabel();
		jLabelLastName = new javax.swing.JLabel();
		jPanel = new javax.swing.JPanel();
		jTextFieldFirstName = new javax.swing.JTextField();
		jTextFieldLastName = new javax.swing.JTextField();

    //This will vary in the future (add/edit)
		setTitle("Client Tracker - Add Client");

		jPanel.setBackground(new java.awt.Color(76, 239, 220));
		jPanel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.setLayout(null);

		jLabelFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelFirstName.setText("First Name:");
		jPanel.add(jLabelFirstName);
		jLabelFirstName.setBounds(50, 25, 100, 25);

		jTextFieldFirstName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldFirstName);
		jTextFieldFirstName.setBounds(150, 25, 200, 25);

		jLabelLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelLastName.setText("Last Name:");
		jPanel.add(jLabelLastName);
		jLabelLastName.setBounds(50, 75, 100, 25);

		jTextFieldLastName.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.add(jTextFieldLastName);
		jTextFieldLastName.setBounds(150, 75, 200, 25);

		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonCancel.setLabel("Cancel");
		jPanel.add(jButtonCancel);
		jButtonCancel.setBounds(25, 125, 150, 50);

		jButtonSubmitClient.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonSubmitClient.setLabel("Add Client"); //This will vary in the future (add/edit)
    setEnabledSubmitClientButton(false);
		jPanel.add(jButtonSubmitClient);
		jButtonSubmitClient.setBounds(225, 125, 150, 50);

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

  public javax.swing.JTextField getTextFieldFirstName(){
		return jTextFieldFirstName;
	}

  public javax.swing.JTextField getTextFieldLastName(){
		return jTextFieldLastName;
	}

	public javax.swing.JButton getCancelButton(){
		return jButtonCancel;
	}

  public javax.swing.JButton getSubmitClientButton(){
		return jButtonSubmitClient;
	}

  public void setEnabledSubmitClientButton(boolean enabled){
		jButtonSubmitClient.setEnabled(enabled);
	}

	private ArrayList<Note> notes;
  private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonSubmitClient;
	private javax.swing.JLabel jLabelFirstName;
	private javax.swing.JLabel jLabelLastName;
	private javax.swing.JPanel jPanel;
	private javax.swing.JTextField jTextFieldFirstName;
	private javax.swing.JTextField jTextFieldLastName;
}