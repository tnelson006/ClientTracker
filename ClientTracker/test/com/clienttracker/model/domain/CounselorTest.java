package com.clienttracker.model.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Travis Nelson
 *
 * This test class exercises the Client class.
 */
public class CounselorTest {

	@Test
	public void testConstructorOne() {
		Note note = new Note("Test Note");
		ArrayList<Note> notes = new ArrayList<Note> ();
		notes.add(note);
		Client testClient = new Client(50, "Test", "Client", notes);

		ArrayList<Client> clients = new ArrayList<Client> ();
		clients.add(testClient);
		Counselor testCounselor = new Counselor(50, "Travis", "Nelson", clients);

    //Test values
    assertTrue(50 == testCounselor.getUniqueID());
    assertTrue("Travis".equals(testCounselor.getFirstName()));
    assertTrue("Nelson".equals(testCounselor.getLastName()));
    assertTrue(clients == testCounselor.getClients());
	}

  @Test
	public void testConstructorTwo() {
		Note note = new Note("Test Note");
		ArrayList<Note> notes = new ArrayList<Note> ();
		notes.add(note);
		Client testClient = new Client(50, "Test", "Client", notes);

		ArrayList<Client> clients = new ArrayList<Client> ();
		clients.add(testClient);
		Counselor testCounselor = new Counselor("Travis", "Nelson", clients);

    //Test values
    assertTrue("Travis".equals(testCounselor.getFirstName()));
    assertTrue("Nelson".equals(testCounselor.getLastName()));
    assertTrue(clients == testCounselor.getClients());
	}

  @Test
	public void testSetters() {
		Note note = new Note("Test Note");
		ArrayList<Note> notes = new ArrayList<Note> ();
		notes.add(note);
		Client testClient = new Client(50, "Test", "Client", notes);

		ArrayList<Client> clients = new ArrayList<Client> ();
		clients.add(testClient);
		Counselor testCounselor = new Counselor("Travis", "Nelson", clients);

    //Test values
    assertTrue("Travis".equals(testCounselor.getFirstName()));
    assertTrue("Nelson".equals(testCounselor.getLastName()));
    assertTrue(clients == testCounselor.getClients());

    testCounselor.setUniqueID(20);
    testCounselor.setFirstName("Jimmy");
    testCounselor.setLastName("John");
    Note newNote = new Note("New Note");
    notes.add(newNote);
    testCounselor.getClients().get(0).setNotes(notes);

    //Test values
    assertTrue(20 == testCounselor.getUniqueID());
    assertTrue("Jimmy".equals(testCounselor.getFirstName()));
    assertTrue("John".equals(testCounselor.getLastName()));
    assertTrue(clients == testCounselor.getClients());
	}
}
