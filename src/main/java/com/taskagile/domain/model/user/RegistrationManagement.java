package com.taskagile.domain.model.user;

import org.springframework.stereotype.Component;

@Component
public class RegistrationManagement {
  private UserRepository repository;

  public RegistrationManagement(UserRepository repository) {
    this.repository = repository;
  }

  public User register(String username, String emailAddress, String password) throws RegistrationException {
    User existUser = repository.findByUsername(username);
    if (existUser != null) {
      throw new UsernameExistsException();
    }

    existUser = repository.findByEmailAddress(emailAddress);
    if (existUser != null) {
      throw new EmailAddressExistsException();
    }

    User user = User.create(username, emailAddress, password);
    repository.save(user);
    return user;
  }
}
