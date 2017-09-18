package ru.stqa.pft.addressbook.tests;
//123

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddingContact extends TestBase {

  @Test
  public void testAddingContact() {

    app.getUserHelper().gotoUserPage();
    List<UserData> before = app.getUserHelper().getUserList();
    UserData user = new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1");
    //int before = app.getUserHelper().getUserCount(); теперь выше содержит список элементов
    app.getUserHelper().initUserCreation();
    app.getUserHelper().fillUserForm(user, true);
    app.getUserHelper().submitUserCreation();
    app.getNavigationHelper().gotoHomePage();
    List<UserData> after = app.getUserHelper().getUserList();
    //int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    user.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(user);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
