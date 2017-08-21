package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase {


  public UserHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitUserCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillUserForm(UserData userData) {
type(By.name("firstname"),userData.getFirstName());
type(By.name("middlename"),userData.getMiddlename() );
type(By.name("lastname"),userData.getLastname());
type(By.name("nickname"),userData.getNickname());
type(By.name("nickname"),userData.getNickname());
type(By.name("title"),userData.getTitle());
type(By.name("company"),userData.getCompany() );
type(By.name("address"),userData.getAddress() );

  }

  public void initUserCreation() {
    click(By.linkText("add new"));
  }
}
