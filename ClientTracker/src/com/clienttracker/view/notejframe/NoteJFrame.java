/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttracker.view.notejframe;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import com.clienttracker.model.domain.Note;
import com.clienttracker.view.mainjframe.MainJFrameController;

/**
 * @author Travis Nelson
 *
 * This class creates and displays all of the UI elements for the AddNote window.
 */
public class NoteJFrame extends javax.swing.JFrame{

  private Note note;
	private NoteJFrameController noteJFrameController;
  private boolean newNote;

  public NoteJFrame(Note note, MainJFrameController mainJFrameController){

    this.note = note;
		initComponents();

		noteJFrameController = new NoteJFrameController(this, mainJFrameController);

		this.setResizable(true);
		this.setMinimumSize(new Dimension(450, 450));
		this.setMaximumSize(new Dimension(450, 450));
		this.pack();
		this.setVisible(true);
	}

	@SuppressWarnings("deprecation")
	private void initComponents(){

		jButtonCancel = new javax.swing.JButton();
		jButtonSaveNote = new javax.swing.JButton();
		jLabelNote = new javax.swing.JLabel();
		jPanel = new javax.swing.JPanel();
		jTextAreaNote = new javax.swing.JTextArea();

		if(note != null) setTitle("Client Tracker - Edit Note");
    else setTitle("Client Tracker - Add Note");

		jPanel.setBackground(new java.awt.Color(76, 239, 220));
		jPanel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jPanel.setLayout(null);

		jLabelNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jLabelNote.setText("Note:");
		jPanel.add(jLabelNote);
		jLabelNote.setBounds(25, 25, 100, 25);

		jTextAreaNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jTextAreaNote.setLineWrap(true);
    if(note != null) jTextAreaNote.setText(note.getText());

		jScrollPaneText = new javax.swing.JScrollPane(jTextAreaNote, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneText.setPreferredSize(new Dimension(400, 250));
		jPanel.add(jScrollPaneText);
		jScrollPaneText.setBounds(25, 50, 400, 250);

		jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11));
		jButtonCancel.setText("Cancel");
		jPanel.add(jButtonCancel);
		jButtonCancel.setBounds(25, 350, 150, 50);

		jButtonSaveNote.setFont(new java.awt.Font("Comic Sans MS", 1, 11));

    if(note != null) {
      jButtonSaveNote.setText("Edit Note");
      newNote = false;
    }
    else {
      jButtonSaveNote.setText("Add Note");
      newNote = true;
    }

		setEnabledSaveNoteButton(true);
		jPanel.add(jButtonSaveNote);
		jButtonSaveNote.setBounds(250, 350, 150, 50);

		getContentPane().add(jPanel);

		pack();
	}

	public Note getEnteredData(){
		Note note = new Note(jTextAreaNote.getText());
		return note;
	}

	public javax.swing.JButton getSaveNoteButton(){
		return jButtonSaveNote;
	}

	public javax.swing.JButton getCancelButton(){
		return jButtonCancel;
	}

	public void setEnabledSaveNoteButton(boolean enabled){
		jButtonSaveNote.setEnabled(enabled);
	}

  public boolean isNoteNew(){
    return newNote;
  }

	private javax.swing.JButton jButtonCancel;
	private javax.swing.JButton jButtonSaveNote;
	private javax.swing.JLabel jLabelNote;
	private javax.swing.JPanel jPanel;
	private javax.swing.JScrollPane jScrollPaneText;
	private javax.swing.JTextArea jTextAreaNote;
}
