package ru.stqa.pft.addressbook.tests;
//123

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class AddingContact extends TestBase {

  @Test
  public void testAddingContact() {

    app.user().home();
    List<UserData> before = app.user().list();
    UserData user = new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1");
    //int before = app.user().getUserCount(); теперь выше содержит список элементов
    app.user().initUserCreation();
    app.user().fillUserForm(user, true);
    app.user().submitUserCreation();
    app.goTo().gotoHomePage();
    List<UserData> after = app.user().list();
    //int after = app.user().getUserCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    user.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
