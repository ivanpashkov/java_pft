package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserHelper extends HelperBase {


  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitUserCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillUserForm(UserData userData, boolean creation) {
    type(By.name("firstname"), userData.getFirstName());
    type(By.name("middlename"), userData.getMiddlename());
    type(By.name("lastname"), userData.getLastname());
    type(By.name("nickname"), userData.getNickname());
    type(By.name("nickname"), userData.getNickname());
    type(By.name("title"), userData.getTitle());
    type(By.name("company"), userData.getCompany());
    type(By.name("address"), userData.getAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());

    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }


  public void initUserCreation() {
    click(By.linkText("add new"));
  }

  public void editUser() {
    //click(By.xpath("//img[@alt='Edit']")); - old
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); - my old
    List<UserData> users = new ArrayList<UserData>();
    WebElement link = wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
    link.click();
}

  public void editLastUser() {
    List<UserData> users = new ArrayList<UserData>();
    WebElement link = wd.findElement(By.xpath("//tr[@name='entry'][last()]/td[8]/a"));
    link.click();
    //Assert.assertNotNull(link);

  }

  public void confirmUserEdit() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void home() {
    click(By.linkText("home"));
  }

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectUserbyId(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteUser() {

    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void create(UserData User, boolean b) {
    initUserCreation();
    fillUserForm((User), b);
    submitUserCreation();
    home();
  }



  public void modify(UserData user) {
    editUser();
    //editLastUser();
    fillUserForm(user, false);
    confirmUserEdit();
    home();
  }

  public void delete(int index) {
    selectUser(index);
    deleteUser();
    home();
  }

  public void delete(UserData user) {
    selectUserbyId(user.getId());
    deleteUser();
    home();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));

  }

  public List<UserData> list() {
    List<UserData> users = new ArrayList<UserData>();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement row : rows) {
      List<WebElement> tdList = row.findElements(By.tagName("td"));
      String firstName = tdList.get(2).getText();
      String lastName = tdList.get(3).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      UserData user = new UserData().withId(id).withName(firstName).withLastname(lastName);
      users.add(user);
    }
    return users;
  }

  public Set<UserData> all() {
    Set<UserData> users = new HashSet<UserData>();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement row : rows) {
      List<WebElement> tdList = row.findElements(By.tagName("td"));
      String firstName = tdList.get(2).getText();
      String lastName = tdList.get(3).getText();
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      UserData user = new UserData().withId(id).withName(firstName).withLastname(lastName);
      users.add(user);
    }
    return users;
  }



}
