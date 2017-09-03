package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

public class UserDeletionTest extends TestBase {

  @Test
  public void userDeletionTest() {
    app.getUserHelper().gotoUserPage();
    int before = app.getUserHelper().getUserCount();
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1"), true);
    }
    app.getUserHelper().selectUser(before-1);
    app.getUserHelper().deleteUser();
    app.getUserHelper().gotoUserPage();
    int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after, before - 1);

  }
}
