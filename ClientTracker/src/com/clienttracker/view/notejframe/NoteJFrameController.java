package com.clienttracker.view.notejframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.clienttracker.model.domain.Note;
import com.clienttracker.view.mainjframe.MainJFrameController;

/**
 * @author Travis Nelson
 *
 * This class handles all event listeners for the add note window and passes data
 * from the UI to other classes.
 */
public class NoteJFrameController implements ActionListener{

	private NoteJFrame noteJFrame;
  private MainJFrameController mainJFrameController;

	public NoteJFrameController(NoteJFrame noteJFrame, MainJFrameController mainJFrameController){

		this.noteJFrame = noteJFrame;
    this.mainJFrameController = mainJFrameController;

		noteJFrame.getCancelButton().addActionListener(this);
		noteJFrame.getSaveNoteButton().addActionListener(this);

		noteJFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(noteJFrame.getCancelButton())){
      cancel_actionPerformed();
    }
			
		else if(e.getSource().equals(noteJFrame.getSaveNoteButton())){
			if(noteJFrame.isNoteNew()) {
        addNote_actionPerformed();
      } else {
        editNote_actionPerformed();
      }
    }
	}

	public void cancel_actionPerformed(){
		noteJFrame.dispose();
	}

	public void addNote_actionPerformed(){
		Note note = noteJFrame.getEnteredData();
    mainJFrameController.addNote(note);
    noteJFrame.dispose();
	}

  public void editNote_actionPerformed(){
		Note note = noteJFrame.getEnteredData();
    mainJFrameController.editNote(note);
    noteJFrame.dispose();
	}
}