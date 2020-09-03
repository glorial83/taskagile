package com.taskagile.domain.application;

import javax.transaction.Transactional;

import com.taskagile.domain.application.commands.RegistrationCommand;
import com.taskagile.domain.model.user.RegistrationException;
import com.taskagile.domain.model.user.RegistrationManagement;
import com.taskagile.domain.model.user.User;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@Transactional
public class UserService {

  private RegistrationManagement registrationManager;

  public UserService(RegistrationManagement registrationManager) {
    this.registrationManager = registrationManager;
  }

  public void register(RegistrationCommand command) throws RegistrationException {
    Assert.notNull(command, "Parameter `command` must not be null");
    User newUser = registrationManager.register(command.getUsername(), command.getEmailAddress(),
        command.getPassword());
  }
}
