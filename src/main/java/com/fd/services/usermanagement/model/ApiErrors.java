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
 * ApiErrors
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-09T00:25:07.019Z")

public class ApiErrors   {
  @JsonProperty("success")
  private String success = "false";

  @JsonProperty("ApiError")
  @Valid
  private List<ApiError> apiError = null;

  public ApiErrors success(String success) {
    this.success = success;
    return this;
  }

  /**
   * Get success
   * @return success
  **/
  @ApiModelProperty(value = "")


  public String getSuccess() {
    return success;
  }

  public void setSuccess(String success) {
    this.success = success;
  }

  public ApiErrors apiError(List<ApiError> apiError) {
    this.apiError = apiError;
    return this;
  }

  public ApiErrors addApiErrorItem(ApiError apiErrorItem) {
    if (this.apiError == null) {
      this.apiError = new ArrayList<ApiError>();
    }
    this.apiError.add(apiErrorItem);
    return this;
  }

  /**
   * Get apiError
   * @return apiError
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ApiError> getApiError() {
    return apiError;
  }

  public void setApiError(List<ApiError> apiError) {
    this.apiError = apiError;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiErrors apiErrors = (ApiErrors) o;
    return Objects.equals(this.success, apiErrors.success) &&
        Objects.equals(this.apiError, apiErrors.apiError);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, apiError);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiErrors {\n");
    
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    apiError: ").append(toIndentedString(apiError)).append("\n");
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

