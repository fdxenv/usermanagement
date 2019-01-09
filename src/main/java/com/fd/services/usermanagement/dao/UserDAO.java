package com.fd.services.usermanagement.dao;

import com.fd.services.usermanagement.model.UserDTO;

public interface UserDAO {

	public UserDTO addUser(UserDTO iUser);
	public UserDTO getUser(long iUserId);
}
