package com.fd.services.usermanagement.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="USER")
public class User {

	 private Long userId = null;
	 private String loginName = null;
	 private String loginPassword = null;
	 private Integer userType = null;
	 private String firstName = null;
	 private String lastName = null;
	 private Set<UserCodes> userCodes = null;
	 private UserPreferences userPreferences = null;
	 
	 @Column(name= "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name= "LASTNAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<UserCodes>  getUserCodes() {
		return userCodes;
	}
	public void setUserCodes(Set<UserCodes> userCodes) {
		this.userCodes = userCodes;
	}

	 @OneToOne(fetch = FetchType.LAZY, mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
	 public UserPreferences getUserPreferences() {
		return userPreferences;
	}
	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID", unique = true, nullable = false)
	 public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name= "LOGINNAME")
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@Column(name= "LOGINPASSWORD")
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	@Column(name= "USERTYPE")
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((loginPassword == null) ? 0 : loginPassword.hashCode());
		result = prime * result + ((userCodes == null) ? 0 : userCodes.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userPreferences == null) ? 0 : userPreferences.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
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
		User other = (User) obj;
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
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (loginPassword == null) {
			if (other.loginPassword != null)
				return false;
		} else if (!loginPassword.equals(other.loginPassword))
			return false;
		if (userCodes == null) {
			if (other.userCodes != null)
				return false;
		} else if (!userCodes.equals(other.userCodes))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userPreferences == null) {
			if (other.userPreferences != null)
				return false;
		} else if (!userPreferences.equals(other.userPreferences))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	
	
	 
}
