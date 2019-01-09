package com.fd.services.usermanagement.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-09T00:25:07.019Z")

public class UserDTO   {
  @JsonProperty("userId")
  private Long userId = null;

  @JsonProperty("loginName")
  private String loginName = null;

  @JsonProperty("loginPassword")
  private String loginPassword = null;

  @JsonProperty("userType")
  private Integer userType = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("userCodes")
  @Valid
  private List<UserCodesDTO> userCodes = null;

  @JsonProperty("userPreferences")
  private UserPreferencesDTO userPreferences = null;

  public UserDTO userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User Id 
   * @return userId
  **/
  @ApiModelProperty(example = "12345", readOnly = true, value = "User Id ")


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public UserDTO loginName(String loginName) {
    this.loginName = loginName;
    return this;
  }

  /**
   * User Login Name 
   * @return loginName
  **/
  @ApiModelProperty(example = "John@gmail.com", required = true, value = "User Login Name ")
  @NotNull


  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public UserDTO loginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
    return this;
  }

  /**
   * User Login Password 
   * @return loginPassword
  **/
  @ApiModelProperty(example = "Test12345", required = true, value = "User Login Password ")
  @NotNull


  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }

  public UserDTO userType(Integer userType) {
    this.userType = userType;
    return this;
  }

  /**
   * Type of the user <br> * `1` - Sponsor <br> * `2` - Advisor <br> * `3` - Branch <br> * `4` - Area <br> * `5` - Region <br> example: \"1\" 
   * @return userType
  **/
  @ApiModelProperty(required = true, value = "Type of the user <br> * `1` - Sponsor <br> * `2` - Advisor <br> * `3` - Branch <br> * `4` - Area <br> * `5` - Region <br> example: \"1\" ")
  @NotNull


  public Integer getUserType() {
    return userType;
  }

  public void setUserType(Integer userType) {
    this.userType = userType;
  }

  public UserDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * User First Name 
   * @return firstName
  **/
  @ApiModelProperty(example = "John", value = "User First Name ")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * User Last Name 
   * @return lastName
  **/
  @ApiModelProperty(example = "Doe", value = "User Last Name ")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserDTO userCodes(List<UserCodesDTO> userCodes) {
    this.userCodes = userCodes;
    return this;
  }

  public UserDTO addUserCodesItem(UserCodesDTO userCodesItem) {
    if (this.userCodes == null) {
      this.userCodes = new ArrayList<UserCodesDTO>();
    }
    this.userCodes.add(userCodesItem);
    return this;
  }

  /**
   * Get userCodes
   * @return userCodes
  **/
  @ApiModelProperty(value = "")

  @Valid
@Size(min=0,max=25) 
  public List<UserCodesDTO> getUserCodes() {
    return userCodes;
  }

  public void setUserCodes(List<UserCodesDTO> userCodes) {
    this.userCodes = userCodes;
  }

  public UserDTO userPreferences(UserPreferencesDTO userPreferences) {
    this.userPreferences = userPreferences;
    return this;
  }

  /**
   * Get userPreferences
   * @return userPreferences
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserPreferencesDTO getUserPreferences() {
    return userPreferences;
  }

  public void setUserPreferences(UserPreferencesDTO userPreferences) {
    this.userPreferences = userPreferences;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDTO user = (UserDTO) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.loginName, user.loginName) &&
        Objects.equals(this.loginPassword, user.loginPassword) &&
        Objects.equals(this.userType, user.userType) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.userCodes, user.userCodes) &&
        Objects.equals(this.userPreferences, user.userPreferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, loginName, loginPassword, userType, firstName, lastName, userCodes, userPreferences);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    loginName: ").append(toIndentedString(loginName)).append("\n");
    sb.append("    loginPassword: ").append(toIndentedString(loginPassword)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    userCodes: ").append(toIndentedString(userCodes)).append("\n");
    sb.append("    userPreferences: ").append(toIndentedString(userPreferences)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

