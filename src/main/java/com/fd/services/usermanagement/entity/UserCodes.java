package com.fd.services.usermanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name="USER_CODES")
@IdClass(UserCodesKey.class)
public class UserCodes implements Serializable{


	private Long userId = null;
	private Integer codeType = null;
	private String code = null;
	private User user = null;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	@Column(name= "CODE_TYPE")
	@Id
	public Integer getCodeType() {
		return codeType;
	}

	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}
	
	@Column(name= "CODE")
	@Id
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((codeType == null) ? 0 : codeType.hashCode());
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
		UserCodes other = (UserCodes) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codeType == null) {
			if (other.codeType != null)
				return false;
		} else if (!codeType.equals(other.codeType))
			return false;
		return true;
	}
	
}
