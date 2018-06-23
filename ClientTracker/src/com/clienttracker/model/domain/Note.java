package com.clienttracker.model.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

/**
 * This class serves as the domain object for notes. It possesses the text
 * of the note and the local datetime that the object was created. It also
 * contains all the getters/setters for the class.
 *
 * @author Travis Nelson
 */
public class Note implements Serializable{

	private static final long serialVersionUID = 7661633977L;

  private String text;
  private Integer clientID = null;
  private Date date;

  //
  public Note(String text){
		this.text = text;
    this.date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
	}

  public Note(String text, Date date){
		this.text = text;
    this.date = date;
	}

/**
 * Getter/setter pairs
 */

  public int getClientID() {
    return clientID;
  }

  public void setClientID(int clientID) {
    this.clientID = clientID;
  }

  public Date getDate() {
		return date;
	}

  public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.text);
    hash = 67 * hash + Objects.hashCode(this.date);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Note other = (Note) obj;
    if (!this.clientID.equals(other.clientID)) {
      return false;
    }
    if (!Objects.equals(this.text, other.text)) {
      return false;
    }
    if (!Objects.equals(this.date, other.date)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Note{" + "text=" + text + ", clientID=" + clientID + ", date=" + date + '}';
  }

  /**
	 * Validate if the instance variables are valid/populated
	 *
	 * @return boolean
	 */
	public boolean validate()
	{
		if(text == null) return false;
		if(date == null) return false;

		return true;
	}
}
