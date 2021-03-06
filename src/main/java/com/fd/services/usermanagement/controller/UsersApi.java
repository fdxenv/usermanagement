/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.1-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.fd.services.usermanagement.controller;


import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fd.services.usermanagement.model.ApiErrors;
import com.fd.services.usermanagement.model.UserDTO;
import com.fd.services.usermanagement.model.UserDetails;
import com.fd.services.usermanagement.model.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-09T00:25:07.019Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "To create a new user", nickname = "usersPost", notes = "<font size='2px' color='grey' face='Georgia,serif'>To create a new user.</br></br><b>Sample Input</b><pre><p>{<br>“loginName”: john@gmail.com</a>&quot;,<br>“loginPassword”: “Test12345”,<br>“userType”: 1,<br>“firstName”: “John”,<br>“lastName”: “Doe”,<br>“userCodes”: [<br>{<br>“codeType”: 1,<br>“code”: “ADV25”<br>}<br>],<br>“userPreferences”: {<br>“realtimeQuotes”: “Y”,<br>“delayedQuotes”: “Y”<br>}<br>}</p></pre><br/>Sample Response</b><p>{<br><pre>“success”: true,<br>“userId”: 12345<br>}</p></font>", response = UserResponse.class, tags={ "User Management", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserResponse.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrors.class) })
    @RequestMapping(value = "/app/v1/users",
        method = RequestMethod.POST)
    ResponseEntity<UserResponse> addUser(@ApiParam(value = "Create a new user" ,required=true )  @Valid @RequestBody UserDTO body);


    @ApiOperation(value = "To get user details", nickname = "usersUserIdGet", notes = "<font size='2px' color='grey' face='Georgia,serif'>To create a new user.</br></br><b>Sample Input</b><pre><p></b><pre>/12345</pre><br/></p></pre><br/>Sample Response</b><p>{<br>“loginName”: john@gmail.com</a>&quot;,<br>“loginPassword”: “Test12345”,<br>“userType”: 1,<br>“firstName”: “John”,<br>“lastName”: “Doe”,<br>“userCodes”: [<br>{<br>“codeType”: 1,<br>“code”: “ADV25”<br>}<br>],<br>“userPreferences”: {<br>“realtimeQuotes”: “Y”,<br>“delayedQuotes”: “Y”<br>}</p></font>", response = UserDetails.class, tags={ "User Management", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserDetails.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ApiErrors.class) })
    @RequestMapping(value = "/app/v1//users/{userId}",
        method = RequestMethod.GET)
    ResponseEntity<UserDetails> getUser(@ApiParam(value = "",required=true) @PathVariable("userId") Long userId);

}
