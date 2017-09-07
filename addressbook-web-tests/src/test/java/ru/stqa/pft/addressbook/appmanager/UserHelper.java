package ru.stqa.pft.addressbook.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.ArrayList;
import java.util.List;

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
    click(By.xpath("//img[@alt='Edit']"));
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); - my old
  }

  public void confirmUserEdit() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void gotoUserPage() {
    click(By.linkText("home"));
  }

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteUser() {

    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void createUser(UserData User, boolean b) {
    initUserCreation();
    fillUserForm((User), b);
    submitUserCreation();
    gotoUserPage();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));

  }

  public List<UserData> getUserList() {
    List<UserData> users = new ArrayList<UserData>();
    List<WebElement> rows = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement row : rows) {
      List<WebElement> tdList = row.findElements(By.tagName("td"));
      String firstName = tdList.get(1).getText();
      String lastName = tdList.get(2).getText();
      UserData user = new UserData(firstName, lastName, null, null, null, null, null, null);
      users.add(user);
    }

    return users;
  }
}
