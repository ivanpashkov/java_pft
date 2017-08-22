package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class UserDeletionTest extends TestBase {

  @Test
  public void userDeletionTest() {
    app.getUserHelper().gotoUserPage();
    app.getUserHelper().selectAllUsers();
    app.getUserHelper().deleteUser();

  }
}
