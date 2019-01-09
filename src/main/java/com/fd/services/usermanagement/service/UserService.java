package com.fd.services.usermanagement.service;




import com.fd.services.usermanagement.model.UserDTO;

public interface UserService {
    UserDTO findById(long id);
    UserDTO create(UserDTO user);
}
