package com.taskagile.web.results;

import java.util.HashMap;

import org.springframework.util.Assert;

public class ApiResult extends HashMap<String, Object> {

  private static final long serialVersionUID = 2297234893453849562L;

  private static final String MESSAGE_KEY = "message";
  private static final String ERROR_CODE_KEY = "errorReferenceCode";

  public static ApiResult blank() {
    return new ApiResult();
  }

  public static ApiResult message(String message) {
    Assert.hasText(message, "Parameter `message` must not be blank");

    ApiResult result = new ApiResult();
    result.put(ApiResult.MESSAGE_KEY, message);

    return result;
  }

  public static ApiResult error(String message, String errorReferenceCode) {
    Assert.hasText(message, "Parameter `message` must not be blank");
    Assert.hasText(errorReferenceCode, "Parameter `errorReferenceCode` must not be blank");

    ApiResult result = new ApiResult();
    result.put(ApiResult.MESSAGE_KEY, message);
    result.put(ApiResult.ERROR_CODE_KEY, errorReferenceCode);

    return result;
  }

  public ApiResult add(String key, Object value) {
    Assert.hasText(key, "Parameter `key` must not be blank");
    Assert.notNull(value, "Parameter `value` must not be blank");

    this.put(key, value);

    return this;
  }

}
