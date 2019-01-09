package com.fd.services.usermanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fd.services.usermanagement.dao.UserDAO;
import com.fd.services.usermanagement.model.UserCodesDTO;
import com.fd.services.usermanagement.model.UserDTO;
import com.fd.services.usermanagement.model.UserPreferencesDTO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class UserServiceImplTest {

	private MockMvc mockMvc;


	@Mock
	private UserDAO userDAO;
	
	@InjectMocks
    private UserServiceImpl userService;

	

	@Test
	public void testFindById() {
		

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
		
		userDTOAdded.setUserCodes(userCodeSetDTOAdded);
		userDTOAdded.setUserPreferences(userPreferencesDTOAdded);
	
		userDTOAdded.setUserId(1l);
		
		
		
		when(userDAO.getUser(1l)).thenReturn(userDTOAdded);
		
		UserDTO newuserDTOAdded  = userService.findById(1l);
		assertEquals(newuserDTOAdded.getUserId(), new Long(1));
		assertEquals(newuserDTOAdded.getLoginName(), "sri");
		assertEquals(newuserDTOAdded.getLoginPassword(), "test01");
		assertEquals(newuserDTOAdded.getUserType(), new Integer(1));
		verify(userDAO, times(1)).getUser(1l);
	}

	@Test
	public void testCreate() {
		
		try {
			
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
			
			userDTOAdded.setUserCodes(userCodeSetDTOAdded);
			userDTOAdded.setUserPreferences(userPreferencesDTOAdded);
		
			userDTOAdded.setUserId(1l);
			
			
			
			when(userDAO.addUser(userDTO)).thenReturn(userDTOAdded);
			
			UserDTO newuserDTOAdded  = userService.create(userDTO);
			assertEquals(newuserDTOAdded.getUserId(), new Long(1));
			assertEquals(newuserDTOAdded.getLoginName(), "sri");
			assertEquals(newuserDTOAdded.getLoginPassword(), "test01");
			assertEquals(newuserDTOAdded.getUserType(), new Integer(1));
			verify(userDAO, times(1)).addUser(userDTO);
			            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
	}

}
