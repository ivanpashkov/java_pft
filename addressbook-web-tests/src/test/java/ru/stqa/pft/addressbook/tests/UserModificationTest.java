package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserModificationTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions(){
    app.user().home();
    //int before = app.user().getUserCount();

    if (app.user().all().size()==0) {
      app.user().create(new UserData().withName("testName").withMiddlename("testMiddlename").withLastname("testLastname").withNickname("testNickname").withTitle("Mr").withCompany("Ololo").withAddress("testaddress").withGroup("test1"), true);
    }

  }

  @Test
  public void userModificationTest() {

    Set<UserData> before = app.user().all();
    UserData modifiedUser = before.iterator().next();
    UserData user = new UserData().withId(modifiedUser.getId()).withName("modtestName").withMiddlename("modtestMiddlename").withLastname("modtestLastname").withNickname("modtestNickname").withTitle("modMr").withCompany("modOlolo").withAddress("modtestaddress").withGroup("modtest1");
    //app.user().selectUser(before.size()-1);
    app.user().editUser(1);
    app.user().modify(user);
    Set<UserData> after = app.user().all();
    //int after = app.user().getUserCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedUser);
    before.add(user);
    Assert.assertEquals(before, after);
  }



}
