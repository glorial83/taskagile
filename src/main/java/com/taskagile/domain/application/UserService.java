package com.taskagile.domain.application;

import com.taskagile.domain.application.commands.RegistrationCommand;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserService {
  public void register(RegistrationCommand command) {
    Assert.notNull(command, "Parameter `command` must not be null");
  }
}
