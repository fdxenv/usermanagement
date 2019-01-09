package com.fd.services.usermanagement.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fd.services.usermanagement.entity.UserPreferences;
import com.fd.services.usermanagement.entity.UserRepository;
import com.fd.services.usermanagement.model.UserDTO;
import com.fd.services.usermanagement.model.UserCodesDTO;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO addUser(UserDTO iUser) {
		
		System.out.println("In UserDAOImpl addUser=" + iUser );
		com.fd.services.usermanagement.entity.User userPersistance = convertDTOToEntity(iUser);
		em.persist(userPersistance);
		System.out.println("In UserDAOImpl userPersistance new=" + userPersistance.getUserId() );
		iUser.setUserId(userPersistance.getUserId());
		return iUser;
	}

	@Override
	public UserDTO getUser(long iUserId) {
		
		System.out.println("In get user");
		Optional<com.fd.services.usermanagement.entity.User> userPersistance  = userRepository.findById(iUserId);
		System.out.println("In get user 1="+userPersistance);
		if(isPresent(userPersistance)) {
			System.out.println("In get user 2="+userPersistance);
			Mapper mapper = new DozerBeanMapper();
			com.fd.services.usermanagement.model.UserDTO userDTO = mapper.map(userPersistance.get(), com.fd.services.usermanagement.model.UserDTO.class);
			return userDTO;
		}
		return new UserDTO();
	}

	public boolean isPresent(Optional<com.fd.services.usermanagement.entity.User>  iUserPersistance) {
		return iUserPersistance.isPresent();
	}
	public com.fd.services.usermanagement.entity.User convertDTOToEntity(UserDTO iUser) {
		
		com.fd.services.usermanagement.entity.User userPersistance  = new com.fd.services.usermanagement.entity.User();
		userPersistance.setLoginName(iUser.getLoginName());
		userPersistance.setLoginPassword(iUser.getLoginPassword());
		userPersistance.setUserType(iUser.getUserType());
		userPersistance.setFirstName(iUser.getFirstName());
		userPersistance.setLastName(iUser.getLastName());
		userPersistance.setUserCodes(new HashSet());
		userPersistance.setUserPreferences(new UserPreferences());
		
		for(UserCodesDTO codeDTO: iUser.getUserCodes()) {
			
			com.fd.services.usermanagement.entity.UserCodes userCodePersitance = new com.fd.services.usermanagement.entity.UserCodes();
			userCodePersitance.setCodeType(codeDTO.getCodeType());
			userCodePersitance.setCode(codeDTO.getCode());
			userCodePersitance.setUser(userPersistance);
			
		}
	     userPersistance.getUserPreferences().setDelayedQuotes(iUser.getUserPreferences().getDelayedQuotes());
	     userPersistance.getUserPreferences().setRealtimeQuotes(iUser.getUserPreferences().getRealtimeQuotes());
	     
		userPersistance.getUserPreferences().setUser(userPersistance);
		System.out.println("In Controller user userPersistance="+userPersistance);
		System.out.println("In Controller user userPersistance="+userPersistance.getUserCodes());
		return userPersistance;
	}
}
