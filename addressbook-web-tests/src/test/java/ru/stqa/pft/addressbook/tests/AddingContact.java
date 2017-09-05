package ru.stqa.pft.addressbook.tests;
//123
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

public class AddingContact extends TestBase {

  @Test
    public void testAddingContact () {

    app.getUserHelper().gotoUserPage();
    List<UserData> before = app.getUserHelper().getUserList();
    //int before = app.getUserHelper().getUserCount(); теперь выше содержит список элементов
    app.getUserHelper().initUserCreation();
    app.getUserHelper().fillUserForm(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1"), true);
    app.getUserHelper().submitUserCreation();
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    //int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after.size(), before.size() + 1);

  }

}
