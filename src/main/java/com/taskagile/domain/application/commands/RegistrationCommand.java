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
  public boolean equals(Object o) {

    System.out.println("equals 호출됨");

    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    RegistrationCommand that = (RegistrationCommand) o;
    if (username != null ? !username.equals(that.username) : that.username != null)
      return false;
    if (emailAddress != null ? !emailAddress.equals(that.emailAddress) : that.emailAddress != null)
      return false;
    return password != null ? password.equals(that.password) : that.password == null;
  }

  @Override
  public int hashCode() {
    int result = username != null ? username.hashCode() : 0;
    result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);

    System.out.println(String.format("hashcode 호출됨: {}", result));

    return result;
  }

  @Override
  public String toString() {
    return "RegistrationCommand{" + "username='" + username + '\'' + ", emailAddress='" + emailAddress + '\''
        + ", password='" + password + '\'' + '}';
  }
}
