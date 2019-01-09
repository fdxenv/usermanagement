package com.fd.services.usermanagement.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fd.services.usermanagement.dao.UserDAO;
import com.fd.services.usermanagement.model.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
    
    @Override
    public UserDTO findById(long id){
    	System.out.println("In UserServiceImpl findById="+id);
    /*	UserDTO userDTO = new UserDTO();
    	userDTO.setUserId(1l);
    	return 	userDTO;*/
    	
    	return userDAO.getUser(id);
    }

 
    @Override
    public UserDTO create(UserDTO user) {
    	System.out.println("In UserServiceImpl create user="+user);
       /* user.setUserId(1l);
        users.add(user);
        return user;*/
    	return userDAO.addUser(user);
    }

   

}
