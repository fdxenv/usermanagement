package com.fd.services.usermanagement.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fd.services.usermanagement.entity.User;
import com.fd.services.usermanagement.entity.UserPreferences;
import com.fd.services.usermanagement.entity.UserRepository;
import com.fd.services.usermanagement.model.UserCodesDTO;
import com.fd.services.usermanagement.model.UserDTO;
import com.fd.services.usermanagement.model.UserPreferencesDTO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:application-context.xml" })

public class UserDAOImplTest {

	
	@Mock
	EntityManager em;
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserDAOImpl userDAO;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddUser() {
		
		List<UserCodesDTO> userCodeSetDTO = new ArrayList<>();
		UserCodesDTO userCodesDTO1 = new UserCodesDTO();
		userCodesDTO1.setCodeType(1);
		userCodesDTO1.setCode("ADV1");

		UserCodesDTO userCodesDTO2 = new UserCodesDTO();
		userCodesDTO2.setCodeType(1);
		userCodesDTO2.setCode("ADV1");
		
		userCodeSetDTO.add(userCodesDTO1);
		userCodeSetDTO.add(userCodesDTO2);
		
		
		
		UserPreferencesDTO userPreferencesDTO = new UserPreferencesDTO();
		userPreferencesDTO.setRealtimeQuotes("N");
		userPreferencesDTO.setDelayedQuotes("Y");
		
		
		UserDTO userDTO = new UserDTO();
		userDTO.setLoginName("sri");
		userDTO.setLoginPassword("test01");
		userDTO.setUserType(1);
	
		
		userDTO.setUserCodes(userCodeSetDTO);
		userDTO.setUserPreferences(userPreferencesDTO);
		
		 User userPersistance = convertDTOToEntity(userDTO);
		 
	
		 doNothing().when(em).persist(userPersistance);
		 
		 UserDTO newUserDTO= userDAO.addUser(userDTO);
		 newUserDTO.setUserId(1l);
		assertEquals(newUserDTO.getUserId(), new Long(1));
		assertEquals(newUserDTO.getLoginName(), "sri");
		assertEquals(newUserDTO.getLoginPassword(), "test01");
		assertEquals(newUserDTO.getUserType(), new Integer(1));
			
		// verify(em, times(1)).persist(userPersistance);
		
	}

	@Test
	public void testGetUser() {
		List<UserCodesDTO> userCodeSetDTOAdded = new ArrayList<>();
		UserCodesDTO userCodesDTO1Added = new UserCodesDTO();
		userCodesDTO1Added.setCodeType(1);
		userCodesDTO1Added.setCode("ADV1");

		UserCodesDTO userCodesDTO2Added = new UserCodesDTO();
		userCodesDTO2Added.setCodeType(1);
		userCodesDTO2Added.setCode("ADV1");
		
		userCodeSetDTOAdded.add(userCodesDTO1Added);
		userCodeSetDTOAdded.add(userCodesDTO2Added);
		
		
		
		UserPreferencesDTO userPreferencesDTOAdded = new UserPreferencesDTO();
		userPreferencesDTOAdded.setRealtimeQuotes("N");
		userPreferencesDTOAdded.setDelayedQuotes("Y");
		
		
		UserDTO userDTOAdded = new UserDTO();
		userDTOAdded.setLoginName("sri");
		userDTOAdded.setLoginPassword("test01");
		userDTOAdded.setUserType(1);
		userDTOAdded.setFirstName("sri");
		userDTOAdded.setLastName("palchuri");
		userDTOAdded.setUserCodes(userCodeSetDTOAdded);
		userDTOAdded.setUserPreferences(userPreferencesDTOAdded);
	
		userDTOAdded.setUserId(1l);
		
		User userPersistanceTobeAdded = convertDTOToEntity(userDTOAdded);
		
		Optional<com.fd.services.usermanagement.entity.User> userPersistance  = Optional.of(userPersistanceTobeAdded);
		
		when(userRepository.findById(1l)).thenReturn(userPersistance);
		
		UserDTO newuserDTOAdded  = userDAO.getUser(1l);
		assertEquals(newuserDTOAdded.getUserId(), new Long(1));
		assertEquals(newuserDTOAdded.getLoginName(), "sri");
		assertEquals(newuserDTOAdded.getLoginPassword(), "test01");
		assertEquals(newuserDTOAdded.getUserType(), new Integer(1));
		verify(userRepository, times(1)).findById(1l);
	}

public com.fd.services.usermanagement.entity.User convertDTOToEntity(UserDTO iUser) {
		
			
		com.fd.services.usermanagement.entity.User userPersistance  = new com.fd.services.usermanagement.entity.User();
		userPersistance.setUserId(1l);
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
