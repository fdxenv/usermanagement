package com.fd.services.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity(name="USER_PREFERENCES")
public class UserPreferences {

	private Long userId = null;
	private String realtimeQuotes = null;
	private String delayedQuotes = null;
	private User user = null;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	@GenericGenerator(name = "fgen", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@GeneratedValue(generator = "fgen")
	@Column(name = "USERID")
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name= "REALTIME_QUOTES")
	public String getRealtimeQuotes() {
		return realtimeQuotes;
	}
	public void setRealtimeQuotes(String realtimeQuotes) {
		this.realtimeQuotes = realtimeQuotes;
	}
	
	@Column(name= "DELAYED_QUOTES")
	public String getDelayedQuotes() {
		return delayedQuotes;
	}
	public void setDelayedQuotes(String delayedQuotes) {
		this.delayedQuotes = delayedQuotes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delayedQuotes == null) ? 0 : delayedQuotes.hashCode());
		result = prime * result + ((realtimeQuotes == null) ? 0 : realtimeQuotes.hashCode());
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
		UserPreferences other = (UserPreferences) obj;
		if (delayedQuotes == null) {
			if (other.delayedQuotes != null)
				return false;
		} else if (!delayedQuotes.equals(other.delayedQuotes))
			return false;
		if (realtimeQuotes == null) {
			if (other.realtimeQuotes != null)
				return false;
		} else if (!realtimeQuotes.equals(other.realtimeQuotes))
			return false;
		return true;
	}
	
	  
}
