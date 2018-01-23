package model;

//import introsde.document.dao.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
  // indicates that this class is an entity to persist in DB
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String userId;
    private String artistId;
    private String artistName;
    private Integer rate;
    
	
    public void setRate(Integer rate) {
    	this.rate = rate;
    }
    
    public Integer getRate() {
    	return this.rate;
    }
    
    public String getUserId() {
    	return this.userId;
    }
    
    public void setUserId(String userId) {
    	this.userId = userId;
    }
    
    public String getArtistId() {
    	return this.artistId;
    }
    
    public void setArtistId(String artistId) {
    	this.artistId = artistId;
    }
    
    public String getArtistName() {
    	return this.artistName;
    }
    
    public void setArtistName(String artistName) {
    	this.artistName = artistName;
    }

}