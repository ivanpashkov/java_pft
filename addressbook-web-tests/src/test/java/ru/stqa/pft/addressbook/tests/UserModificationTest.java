package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.user().home();
    //int before = app.user().getUserCount();

    if (app.user().list().size()==0) {
      app.user().create(new UserData().withName("testName").withMiddlename("testMiddlename").withLastname("testLastname").withNickname("testNickname").withTitle("Mr").withCompany("Ololo").withAddress("testaddress").withGroup("test1"), true);
    }

  }

  @Test
  public void userModificationTest() {

    List<UserData> before = app.user().list();
    int index = before.size()-1;
    UserData user = new UserData().withId(before.get(index).getId()).withName("modtestName").withMiddlename("modtestMiddlename").withLastname("modtestLastname").withNickname("modtestNickname").withTitle("modMr").withCompany("modOlolo").withAddress("modtestaddress").withGroup("modtest1");
    //app.user().selectUser(before.size()-1);
    app.user().modify(user);
    List<UserData> after = app.user().list();
    //int after = app.user().getUserCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
