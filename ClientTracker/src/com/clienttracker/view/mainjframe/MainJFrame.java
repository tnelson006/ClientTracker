package com.clienttracker.view.mainjframe;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import com.clienttracker.model.domain.Client;
import com.clienttracker.model.domain.Note;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

/**
 * MainJFrame creates and displays all of the UI elements for the main window.
 */
public class MainJFrame extends javax.swing.JFrame{

	private static final long serialVersionUID = 20L;

	public MainJFrame(){

		initComponents();

		this.setSize(1200, 700);
		this.setVisible(true);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	private void initComponents(){
		jDesktopPane = new JDesktopPane();
		jFileMenu = new javax.swing.JMenu();
		jFileMenuItemExit = new javax.swing.JMenuItem();
		jMenuBar = new javax.swing.JMenuBar();
		setJMenuBar(jMenuBar);
    jButtonAddClient = new javax.swing.JButton();
    jButtonDeleteClient = new javax.swing.JButton();
		jButtonAddNote = new javax.swing.JButton();
    jButtonDeleteNote = new javax.swing.JButton();
    jButtonEditNote = new javax.swing.JButton();
		jLabelClient = new javax.swing.JLabel();
		jLabelNote = new javax.swing.JLabel();
		jPanel = new javax.swing.JPanel();

    jPanel.setBackground(new java.awt.Color(76, 239, 220));
		jPanel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.setLayout(null);

		jLabelNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelNote.setText("Notes:");
		jPanel.add(jLabelNote);
		jLabelNote.setBounds(300, 25, 100, 25);

		jLabelClient.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelClient.setText("Clients:");
		jPanel.add(jLabelClient);
		jLabelClient.setBounds(25, 25, 100, 25);

		jListClients = new javax.swing.JList(clientArray.toArray());
		jListClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListClients.setLayoutOrientation(JList.VERTICAL);
		jListClients.setVisibleRowCount(-1);

		jScrollPaneClients = new javax.swing.JScrollPane(jListClients);
		jScrollPaneClients.setPreferredSize(new Dimension(250, 250));
		jPanel.add(jScrollPaneClients);
		jScrollPaneClients.setBounds(25, 50, 250, 250);

    jListNotes = new javax.swing.JList(noteArray.toArray());
		jListNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListNotes.setLayoutOrientation(JList.VERTICAL);
		jListNotes.setVisibleRowCount(-1);

		jScrollPaneNotes = new javax.swing.JScrollPane(jListNotes);
		jScrollPaneNotes.setPreferredSize(new Dimension(400, 250));
		jPanel.add(jScrollPaneNotes);
		jScrollPaneNotes.setBounds(300, 50, 800, 250);

		jButtonAddClient.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonAddClient.setText("Add Client");
    setEnabledAddClientButton(true);
		jPanel.add(jButtonAddClient);
		jButtonAddClient.setBounds(25, 325, 150, 50);

    jButtonDeleteClient.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonDeleteClient.setText("Delete Client");
		setEnabledDeleteClientButton(false);
    jPanel.add(jButtonDeleteClient);
		jButtonDeleteClient.setBounds(200, 325, 150, 50);

		jButtonAddNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonAddNote.setText("Add Note");
		setEnabledAddNoteButton(false);
		jPanel.add(jButtonAddNote);
		jButtonAddNote.setBounds(375, 325, 150, 50);

    jButtonEditNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonEditNote.setText("Edit Note");
		setEnabledEditNoteButton(false);
		jPanel.add(jButtonEditNote);
		jButtonEditNote.setBounds(550, 325, 150, 50);

    jButtonDeleteNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonDeleteNote.setText("Delete Note");
		setEnabledDeleteNoteButton(false);
		jPanel.add(jButtonDeleteNote);
		jButtonDeleteNote.setBounds(725, 325, 150, 50);

    jPanel.setSize(1200, 700);
		jPanel.setVisible(true);
    jDesktopPane.add(jPanel);
		this.add(jDesktopPane);
		jDesktopPane.setBackground(new java.awt.Color(76, 239, 220));

		/*
		 * This section is for the menu items that will populate the JInternalFrames within the JDesktopPane
		 */
		jMenuBar.setNextFocusableComponent(jFileMenu);
		jMenuBar.setOpaque(false);

		jFileMenu.setText("File");
		jFileMenu.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

		jFileMenuItemExit.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jFileMenuItemExit.setText("Exit");
		jFileMenu.add(jFileMenuItemExit);

		jMenuBar.add(jFileMenu);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Client Tracker");

		pack();
	}

	public javax.swing.JMenuItem getFileMenuItemExit(){
		return jFileMenuItemExit;
	}

	public void addToJDesktopPane(JInternalFrame jif){
		jDesktopPane.add(jif);
	}

  public javax.swing.JButton getAddNoteButton(){
		return jButtonAddNote;
	}

  public javax.swing.JButton getDeleteNoteButton(){
		return jButtonDeleteNote;
	}

  public javax.swing.JButton getEditNoteButton(){
		return jButtonEditNote;
	}

  public javax.swing.JButton getAddClientButton(){
		return jButtonAddClient;
	}

  public javax.swing.JButton getDeleteClientButton(){
		return jButtonDeleteClient;
  }

  public javax.swing.JList getClientList(){
		return jListClients;
	}

  public int getClientListIndex(){
		return jListClients.getSelectedIndex();
	}

  public Object getClientListValue(){
		return jListClients.getSelectedValue();
	}

  public javax.swing.JList getNoteList(){
		return jListNotes;
	}

  public int getNoteListIndex(){
		return jListNotes.getSelectedIndex();
	}

  public Object getNoteListValue(){
		return jListNotes.getSelectedValue();
	}

  public void setEnabledAddNoteButton(boolean enabled){
		jButtonAddNote.setEnabled(enabled);
	}

  public void setEnabledEditNoteButton(boolean enabled){
		jButtonEditNote.setEnabled(enabled);
	}

  public void setEnabledDeleteNoteButton(boolean enabled){
		jButtonDeleteNote.setEnabled(enabled);
	}

  public void setEnabledAddClientButton(boolean enabled){
		jButtonAddClient.setEnabled(enabled);
	}

  public void setEnabledDeleteClientButton(boolean enabled){
		jButtonDeleteClient.setEnabled(enabled);
  }

	public ArrayList<Client> getClients(){
		return clientArray;
	}

  public void setClients(ArrayList<Client> clients){
    this.clientArray = clients;
		jPanel.remove(jScrollPaneClients);
    jListClients = new javax.swing.JList(clients.toArray());
    jListClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListClients.setLayoutOrientation(JList.VERTICAL);
		jListClients.setVisibleRowCount(-1);

		jScrollPaneClients = new javax.swing.JScrollPane(jListClients);
		jScrollPaneClients.setPreferredSize(new Dimension(250, 250));
		jPanel.add(jScrollPaneClients);
		jScrollPaneClients.setBounds(25, 50, 250, 250);
    pack();
	}

  public void setNotes(List<Note> notes){
		jPanel.remove(jScrollPaneNotes);
    jListNotes = new javax.swing.JList(notes.toArray());
    jListNotes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListNotes.setLayoutOrientation(JList.VERTICAL);
		jListNotes.setVisibleRowCount(-1);

		jScrollPaneNotes = new javax.swing.JScrollPane(jListNotes);
		jScrollPaneNotes.setPreferredSize(new Dimension(250, 250));
		jPanel.add(jScrollPaneNotes);
		jScrollPaneNotes.setBounds(300, 50, 800, 250);
    pack();
	}

	private javax.swing.JScrollPane jScrollPaneClients;
	private javax.swing.JScrollPane jScrollPaneNotes;
	private javax.swing.JDesktopPane jDesktopPane;
	private javax.swing.JMenu jFileMenu;
	private javax.swing.JMenuItem jFileMenuItemExit;
	private javax.swing.JMenuBar jMenuBar;
  private ArrayList<Client> clientArray = new ArrayList<Client>();
  private ArrayList<Client> noteArray = new ArrayList<Client>();
	private javax.swing.JButton jButtonAddClient;
  private javax.swing.JButton jButtonDeleteClient;
	private javax.swing.JButton jButtonAddNote;
  private javax.swing.JButton jButtonEditNote;
  private javax.swing.JButton jButtonDeleteNote;
	private javax.swing.JLabel jLabelClient;
	private javax.swing.JLabel jLabelNote;
	private javax.swing.JList jListClients;
  private javax.swing.JList jListNotes;
	private javax.swing.JPanel jPanel;
}