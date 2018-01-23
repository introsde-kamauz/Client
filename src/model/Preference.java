package model;

//import introsde.document.dao.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
  // indicates that this class is an entity to persist in DB

public class Preference {
    
    private String userId;
    private String artistId;
    private String artistName;
    
    public Preference() {
    	
    }
    
    public Preference(String userId, String artistId) {
    	this.setUserId(userId);
    	this.artistId = artistId;
    }
    
    public String getArtistId() {
    	return this.artistId;
    }
    
    public void setArtistId(String id) {
    	this.artistId = id;
    }
    
    public String getArtistName() {
    	return this.artistName;
    }
    
    public void setArtistName(String name) {
    	this.artistName = name;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}