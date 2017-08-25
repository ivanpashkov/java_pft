package ru.stqa.pft.addressbook.tests;
//123
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

public class AddingContact extends TestBase {

  @Test
    public void testAddingContact () {

    app.getUserHelper().initUserCreation();
    app.getUserHelper().fillUserForm(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1"), true);
    app.getUserHelper().submitUserCreation();
  }

}
