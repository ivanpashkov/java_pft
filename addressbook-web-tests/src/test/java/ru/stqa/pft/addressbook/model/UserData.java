package ru.stqa.pft.addressbook.model;
//123
public class UserData {
  private final String id;
  private final String firstName;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private String group;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (id != null ? !id.equals(userData.id) : userData.id != null) return false;
    return firstName != null ? firstName.equals(userData.firstName) : userData.firstName == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public UserData(String id, String firstName, String middlename, String lastname, String nickname, String title, String company, String address, String group) {
    this.id = id;

    this.firstName = firstName;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.group = group;
  }

  public UserData(String firstName, String middlename, String lastname, String nickname, String title, String company, String address, String group) {
    this.id = null;

    this.firstName = firstName;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.group = group;
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

  public String getGroup() {return group;
  }

}
