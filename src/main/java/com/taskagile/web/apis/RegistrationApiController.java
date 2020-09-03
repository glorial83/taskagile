package com.taskagile.web.apis;

import javax.validation.Valid;

import com.taskagile.domain.application.UserService;
import com.taskagile.web.payload.RegistrationPayload;
import com.taskagile.web.results.ApiResult;
import com.taskagile.web.results.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationApiController {
  @Autowired
  UserService service;

  @PostMapping("/api/registrations")
  public ResponseEntity<ApiResult> register(@Valid @RequestBody RegistrationPayload payload) {
    // try {

    // } catch (RegistrationException re) {
    // String errorMessage = "Registration failed";
    // if (re instanceof UsernameExistsException) {
    // errorMessage = "Username already exists";
    // } else if (re instanceof EmailAddressExistsException) {
    // errorMessage = "Email address already exists";
    // }
    // }

    service.register(payload.toCommand());
    return Result.created();
  }
}
