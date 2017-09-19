package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class UserModificationTest extends TestBase {

  @Test (enabled = false)
  public void userModificationTest() {
    app.getUserHelper().gotoUserPage();
    //int before = app.getUserHelper().getUserCount();

    if (! app.getUserHelper().isThereAUser()) {
      app.getUserHelper().createUser(new UserData("testName", "testMiddlename", "testLastname", "testNickname", "Mr", "Ololo", "testaddress", "test1"), true);
    }
    List<UserData> before = app.getUserHelper().getUserList();
    //app.getUserHelper().selectUser(before.size()-1);
    app.getUserHelper().editUser();
    //app.getUserHelper().editLastUser();
    UserData user = new UserData(before.get(before.size()-1).getId(),"3321", "322", "333", "344", "35", "36", "37", null);
    app.getUserHelper().fillUserForm(user, false);
    app.getUserHelper().confirmUserEdit();
    app.getUserHelper().gotoUserPage();
    List<UserData> after = app.getUserHelper().getUserList();
    //int after = app.getUserHelper().getUserCount();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size()-1);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
