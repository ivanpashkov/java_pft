package ru.stqa.pft.addressbook.tests;
//123

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class AddingContact extends TestBase {

  @Test
  public void testAddingContact() {

    app.user().home();
    Set<UserData> before = app.user().all();
    UserData user = new UserData().withName("testName").withMiddlename("testMiddlename").withLastname("testLastname").withNickname("testNickname").withTitle("Mr").withCompany("Ololo").withAddress("testaddress").withGroup("test1");
    //int before = app.user().getUserCount(); теперь выше содержит список элементов
    app.user().initUserCreation();
    app.user().fillUserForm(user, true);
    app.user().submitUserCreation();
    app.goTo().gotoHomePage();
    Set<UserData> after = app.user().all();
    //int after = app.user().getUserCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    user.withId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());
    //user.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); - what is it?
    before.add(user);
    Assert.assertEquals(before, after);
  }

}
