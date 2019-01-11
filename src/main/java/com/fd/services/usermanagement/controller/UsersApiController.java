package com.fd.services.usermanagement.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fd.services.usermanagement.model.UserDTO;
import com.fd.services.usermanagement.model.UserDetails;
import com.fd.services.usermanagement.model.UserResponse;

import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-09T00:25:07.019Z")

@Controller
public class UsersApiController implements UsersApi {

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private  HttpServletRequest request;
    

    @Autowired
    private com.fd.services.usermanagement.service.UserService userService;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
   
    public ResponseEntity<UserResponse> addUser(@ApiParam(value = "Create a new user" ,required=true )  @Valid @RequestBody UserDTO body) {
    	
    	
    	
    	System.out.println("request.getHeader()="+request.getHeader("Accept"));
    	System.out.println("userService="+userService);
    	
    	 String accept = request.getHeader("Accept");
         if (accept != null && accept.contains("application/json")) {
             try {
            	 
            	 UserDTO newUserDTO = userService.create(body);
            	 UserResponse userResponse = new UserResponse();
             	 userResponse.setUserId(newUserDTO.getUserId());
             	 userResponse.setSuccess("true");
             	
                 return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
             } catch (Exception e) {
                 log.error("Couldn't serialize response for content type application/json", e);
                 return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }

         return new ResponseEntity<UserResponse>(HttpStatus.NOT_IMPLEMENTED);
    

        
    }

    public ResponseEntity<UserDetails> getUser(@ApiParam(value = "",required=true) @PathVariable("userId") Long userId) {
    	
    	
    	 String accept = request.getHeader("Accept");
         if (accept != null && accept.contains("application/json")) {
             try {
            	 
            		UserDetails userDetails = new UserDetails();
                	userDetails.setSuccess("true");
                	
                	 UserDTO userDTO = userService.findById(userId);
                	userDetails.setUser(userDTO);
                
            	  return new ResponseEntity<UserDetails>(userDetails,HttpStatus.OK);
             } catch (Exception e) {
                 log.error("Couldn't serialize response for content type application/json", e);
                 return new ResponseEntity<UserDetails>(HttpStatus.INTERNAL_SERVER_ERROR);
             }
         }

         return new ResponseEntity<UserDetails>(HttpStatus.NOT_IMPLEMENTED);
         
       
    }

}
