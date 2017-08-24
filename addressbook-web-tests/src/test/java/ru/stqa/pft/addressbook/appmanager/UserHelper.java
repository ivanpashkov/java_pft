package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

public class UserHelper extends HelperBase {


  public UserHelper(WebDriver wd) {
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

  public void editUser() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void confirmUserEdit() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void gotoUserPage() {
    click(By.linkText("home"));
  }

  public void selectAllUsers() {
    click(By.name("selected[]"));
  }

  public void deleteUser() {

    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }
}