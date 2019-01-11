package com.fd.services.usermanagement.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.services.usermanagement.dao.UserDAO;
import com.fd.services.usermanagement.model.UserCodesDTO;
import com.fd.services.usermanagement.model.UserDTO;
import com.fd.services.usermanagement.model.UserPreferencesDTO;
import com.fd.services.usermanagement.service.UserService;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:application-context.xml" })
public class UsersApiControllerTest {

	private MockMvc mockMvc;
	
		
    @Mock
    private UserService userService;
	
	@Mock
	private  HttpServletRequest request;

    @InjectMocks
    private UsersApiController userController;
    
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
               // .addFilters(new CORSFilter())
                .build();
         
        when(request.getHeader(anyString())).thenReturn("application/json");
    }
    
    
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddUser() throws Exception{
		
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
			
			
			
			when(userService.create(userDTO)).thenReturn(userDTOAdded);
			//System.out.println("userService.addUser(userDTO)="+userService.addUser(userDTO).getUserId());
			
			 MvcResult result =	  mockMvc.perform(
			            post("/app/v1//users")
			            		.accept(MediaType.APPLICATION_JSON)
			                    .contentType(MediaType.APPLICATION_JSON)
			                  .content(asJsonString(userDTO)))
			            .andExpect(status().isOk())
			            .andReturn();
			 
			 System.out.println("In testUsersPost"+result.getResponse().getContentAsString());
			 verify(userService, times(1)).create(userDTO);
			            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}

	@Test
	public void testgetUser() throws Exception {
	 
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
		
		
		
		when(userService.findById(1l)).thenReturn(userDTOAdded);
		//System.out.println("userService.addUser(userDTO)="+userService.addUser(userDTO).getUserId());
		
		 MvcResult result =	  mockMvc.perform(
		             get("/app/v1/users/1", 1))
		            .andExpect(status().isOk())
		            .andReturn();
		 
		 System.out.println("In testUsersPost"+result.getResponse().getContentAsString());
		 verify(userService, times(1)).findById(1l);
	}
	

	 public static String asJsonString(final Object obj) {
	        try {
	            final ObjectMapper mapper = new ObjectMapper();
	            return mapper.writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
