package com.fd.services.usermanagement.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserCodes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-09T00:25:07.019Z")

public class UserCodesDTO   {
  @JsonProperty("codeType")
  private Integer codeType = null;

  @JsonProperty("code")
  private String code = null;

  public UserCodesDTO codeType(Integer codeType) {
    this.codeType = codeType;
    return this;
  }

  /**
   * Code Type <br> * `1` - Sponsor <br> * `2` - Advisor <br> * `3` - Branch <br> * `4` - Area <br> * `5` - Region <br> 
   * @return codeType
  **/
  @ApiModelProperty(example = "1", value = "Code Type <br> * `1` - Sponsor <br> * `2` - Advisor <br> * `3` - Branch <br> * `4` - Area <br> * `5` - Region <br> ")


  public Integer getCodeType() {
    return codeType;
  }

  public void setCodeType(Integer codeType) {
    this.codeType = codeType;
  }

  public UserCodesDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * User Code like IA/Branch/Area/Region 
   * @return code
  **/
  @ApiModelProperty(example = "ADV25", value = "User Code like IA/Branch/Area/Region ")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserCodesDTO userCodes = (UserCodesDTO) o;
    return Objects.equals(this.codeType, userCodes.codeType) &&
        Objects.equals(this.code, userCodes.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeType, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserCodes {\n");
    
    sb.append("    codeType: ").append(toIndentedString(codeType)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

