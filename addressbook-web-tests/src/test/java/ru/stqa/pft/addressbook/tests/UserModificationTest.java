package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class UserModificationTest extends TestBase {

  @Test
  public void userModificationTest() {
    app.getUserHelper().gotoUserPage();
    //int before = app.getUserHelper().getUserCount();

    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1"), true);
    }
    List<UserData> before = app.getUserHelper().getUserList();
    app.getUserHelper().selectUser(before.size()-1);
    app.getUserHelper().editUser();
    app.getUserHelper().fillUserForm(new UserData("Modified", "testMiddlename3", "testLastname3", "testNickname3", "Mr3", "Ololo3", "testaddress3", null), false);
    app.getUserHelper().confirmUserEdit();
    app.getUserHelper().gotoUserPage();
    List<UserData> after = app.getUserHelper().getUserList();
    //int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after.size(), before.size());
  }

}
