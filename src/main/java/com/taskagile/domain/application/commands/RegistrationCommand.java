package com.taskagile.domain.application.commands;

//getter만 존재 데이터 삽입 후 변환되지 않음
public class RegistrationCommand {
  private String username;
  private String emailAddress;
  private String password;

  public RegistrationCommand(String username, String emailAddress, String password) {
    this.username = username;
    this.emailAddress = emailAddress;
    this.password = password;
  }

  public String getUsername() {
    return this.username;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public String getPassword() {
    return this.password;
  }

  @Override
  public String toString(){
    return (this.username + '/' + this.emailAddress + '/' + this.password);
  }
}
