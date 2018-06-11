package com.clienttracker.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as the domain object for clients. It possesses the
 * information for a specific client, and contains all the getters/setters
 * for the class.
 *
 * @author Travis Nelson
 */
public class Client implements Serializable{

	private static final long serialVersionUID = 7661657477853633935L;

	private Integer uniqueID = null;
	private String firstName;
	private String lastName;
	private List<Note> notes = new ArrayList<>();

	/**
	 * Empty constructor
	 * No parameters
	 *
	public Client(){
	this.notes = new List<Note>();
	}*/

	/**
	 * Constructor
	 * All parameters
	 */
	public Client(int uniqueID, String firstName,
            String lastName, List<Note> notes){
	this.uniqueID = uniqueID;
	this.firstName = firstName;
	this.lastName = lastName;
	this.notes = notes;
	}

	/**
	 * Default constructor
	 * All parameters, minus uniqueID
	 */
	public Client(String firstName, String lastName, List<Note> notes){
		this.firstName = firstName;
		this.lastName = lastName;
		this.notes = notes;
	}

/**
 * Getter/setter pairs
 */

	public Integer getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(Integer uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Note> getNotes(){
		return notes;
	}

	public void addNote(Note note){
		if(notes!=null){
			this.notes.add(note);
		}
	}

	public void setNotes(List<Note> notes){
		this.notes = notes;
	}

  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [uniqueID=" + uniqueID + ", firstName=" + firstName
            + ", lastName=" + lastName + ", notes=" + notes + "]";
	}

	/**
	 * Validate if the instance variables are valid/populated
	 *
	 * @return boolean
	 */
	public boolean validate()
	{
		if(uniqueID == 0) return false;
		if(firstName == null) return false;
		if(lastName == null) return false;
		if(notes == null) return false;

		return true;
	}
}
