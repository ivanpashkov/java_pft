package ru.stqa.pft.addressbook.appmanager;
//123
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  private UserHelper userHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void init() {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    userHelper = new UserHelper(wd);
    login("admin", "secret");
  }

  private void login(String username, String password) {
     userHelper.wd.findElement(By.name("user")).click();
     userHelper.wd.findElement(By.name("user")).clear();
     userHelper.wd.findElement(By.name("user")).sendKeys(username);
     userHelper.wd.findElement(By.name("pass")).click();
     userHelper.wd.findElement(By.name("pass")).clear();
     userHelper.wd.findElement(By.name("pass")).sendKeys(password);
     userHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public UserHelper getUserHelper() {
    return userHelper;
  }
}
