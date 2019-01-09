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
 * UserPreferences
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-09T00:25:07.019Z")

public class UserPreferencesDTO   {
  @JsonProperty("realtimeQuotes")
  private String realtimeQuotes = null;

  @JsonProperty("delayedQuotes")
  private String delayedQuotes = null;

  public UserPreferencesDTO realtimeQuotes(String realtimeQuotes) {
    this.realtimeQuotes = realtimeQuotes;
    return this;
  }

  /**
   * Real time quotes Enabled 
   * @return realtimeQuotes
  **/
  @ApiModelProperty(example = "Y", value = "Real time quotes Enabled ")


  public String getRealtimeQuotes() {
    return realtimeQuotes;
  }

  public void setRealtimeQuotes(String realtimeQuotes) {
    this.realtimeQuotes = realtimeQuotes;
  }

  public UserPreferencesDTO delayedQuotes(String delayedQuotes) {
    this.delayedQuotes = delayedQuotes;
    return this;
  }

  /**
   * Delayed quotes Enabled 
   * @return delayedQuotes
  **/
  @ApiModelProperty(example = "Y", value = "Delayed quotes Enabled ")


  public String getDelayedQuotes() {
    return delayedQuotes;
  }

  public void setDelayedQuotes(String delayedQuotes) {
    this.delayedQuotes = delayedQuotes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserPreferencesDTO userPreferences = (UserPreferencesDTO) o;
    return Objects.equals(this.realtimeQuotes, userPreferences.realtimeQuotes) &&
        Objects.equals(this.delayedQuotes, userPreferences.delayedQuotes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(realtimeQuotes, delayedQuotes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserPreferences {\n");
    
    sb.append("    realtimeQuotes: ").append(toIndentedString(realtimeQuotes)).append("\n");
    sb.append("    delayedQuotes: ").append(toIndentedString(delayedQuotes)).append("\n");
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

