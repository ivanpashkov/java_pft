package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

public class UserModificationTest extends TestBase {

  @Test
  public void userModificationTest() {
    app.getUserHelper().gotoUserPage();
    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1"), true);
    }
    app.getUserHelper().editUser();
    app.getUserHelper().fillUserForm(new UserData("testName3", "testMiddlename3", "testLastname3", "testNickname3", "Mr3", "Ololo3", "testaddress3", null), false);
    app.getUserHelper().confirmUserEdit();
    app.getUserHelper().gotoUserPage();
  }

}
