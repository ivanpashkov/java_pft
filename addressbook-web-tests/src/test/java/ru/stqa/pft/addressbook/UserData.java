package ru.stqa.pft.addressbook;

public class UserData {
  private final String firstName;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;

  public UserData(String firstName, String middlename, String lastname, String nickname, String title, String company, String address) {
    this.firstName = firstName;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }
}
