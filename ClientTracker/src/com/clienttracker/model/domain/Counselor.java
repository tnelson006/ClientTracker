package com.clienttracker.model.domain;

import java.util.ArrayList;

/**
 * This class holds all of the information necessary for a counselor.
 * Getters/setters are defined within this file.
 */
public class Counselor {

	private Integer uniqueID = null;
	private String firstName;
	private String lastName;
  private ArrayList<Client> clients = new ArrayList<>();

	/**
	 * Constructor
	 * All parameters
	 */
	public Counselor(Integer uniqueID, String firstName,
          String lastName, ArrayList<Client> clients){
		this.uniqueID = uniqueID;
		this.firstName = firstName;
		this.lastName = lastName;
    this.clients = clients;
	}

  /**
	 * Default constructor
	 * All parameters, minus uniqueID
	 */
	public Counselor(String firstName, String lastName, ArrayList<Client> clients){
		this.firstName = firstName;
		this.lastName = lastName;
    this.clients = clients;
	}

/**
 * Getter/setter pairs
 */

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
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

  public ArrayList<Client> getClients(){
		return clients;
	}

	public void addClient(Client client){
		if(clients!=null){
			this.clients.add(client);
		}
	}

	public void setClients(ArrayList<Client> clients){
		this.clients = clients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + uniqueID;
    result = prime * result + ((clients == null) ? 0 : clients.hashCode());
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
		Counselor other = (Counselor) obj;
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
		if (!uniqueID.equals(other.uniqueID))
			return false;
    if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Counselor [uniqueID=" + uniqueID + ", firstName=" + firstName
            + ", lastName=" + lastName + ", clients=" + clients +  "]";
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
    if(clients == null) return false;

		return true;
	}
}
