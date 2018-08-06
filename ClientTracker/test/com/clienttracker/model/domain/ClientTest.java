package com.clienttracker.model.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Travis Nelson
 *
 * This test class exercises the Client class.
 */
public class ClientTest {

	@Test
	public void testConstructorOne() {
		Note note = new Note("Test Note");
		ArrayList<Note> notes = new ArrayList<Note> ();
		notes.add(note);
		Client testClient = new Client(50, "Travis", "Nelson", notes);

    //Test values
    assertTrue(50 == testClient.getUniqueID());
    assertTrue("Travis".equals(testClient.getFirstName()));
    assertTrue("Nelson".equals(testClient.getLastName()));
    assertTrue(notes == testClient.getNotes());
	}

  @Test
	public void testConstructorTwo() {
		Note note = new Note("Test Note");
		ArrayList<Note> notes = new ArrayList<Note> ();
		notes.add(note);
		Client testClient = new Client("Travis", "Nelson", notes);

    //Test values
    assertTrue(null == testClient.getUniqueID());
    assertTrue("Travis".equals(testClient.getFirstName()));
    assertTrue("Nelson".equals(testClient.getLastName()));
    assertTrue(notes == testClient.getNotes());
	}

  @Test
	public void testSetters() {
		Note note = new Note("Test Note");
		ArrayList<Note> notes = new ArrayList<Note> ();
		notes.add(note);
		Client testClient = new Client("Travis", "Nelson", notes);

    //Test values
    assertTrue(null == testClient.getUniqueID());
    assertTrue("Travis".equals(testClient.getFirstName()));
    assertTrue("Nelson".equals(testClient.getLastName()));
    assertTrue(notes == testClient.getNotes());

    testClient.setUniqueID(20);
    testClient.setFirstName("Jimmy");
    testClient.setLastName("John");
    Note newNote = new Note("New Note");
    notes.add(newNote);
    testClient.setNotes(notes);

    //Test values
    assertTrue(20 == testClient.getUniqueID());
    assertTrue("Jimmy".equals(testClient.getFirstName()));
    assertTrue("John".equals(testClient.getLastName()));
    assertTrue(notes == testClient.getNotes());
	}
}
