package com.clienttracker.model.domain;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Test;

public class NoteTest {

	@Test
	public void testConstructorOne() {
    Date date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
		Note testNote = new Note("Test Note", date);

    assertTrue("Test Note".equals(testNote.getText()));
    assertTrue(date == testNote.getDate());
	}

  @Test
	public void testConstructorTwo() {
		Note testNote = new Note("Test Note");

    assertTrue("Test Note".equals(testNote.getText()));
    assertTrue(null != testNote.getDate());
	}

  @Test
	public void testSetters() {
    Date date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
		Note testNote = new Note("Test Note");

    assertTrue("Test Note".equals(testNote.getText()));
    assertTrue(null != testNote.getDate());

    testNote.setNoteID(20);
    testNote.setText("New text");
    testNote.setDate(date);

    assertTrue(20 == testNote.getNoteID());
    assertTrue("New text".equals(testNote.getText()));
    assertTrue(date == testNote.getDate());
	}
}
