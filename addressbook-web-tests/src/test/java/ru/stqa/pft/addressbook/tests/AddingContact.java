package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

public class AddingContact extends TestBase {

  @Test
    public void testAddingContact () {

    app.initUserCreation();
    app.fillUserForm(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress"));
    app.submitUserCreation();
  }

}
