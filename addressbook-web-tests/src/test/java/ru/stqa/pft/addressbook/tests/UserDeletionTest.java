package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;
import java.util.Set;

public class UserDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.user().home();
    //int before = app.user().getUserCount();
    if (app.user().list().size()==0) {
      app.user().create(new UserData().withName("test1"), true);
    }
  }

  @Test
  public void userDeletionTest() {

    Set<UserData> before = app.user().all();
    UserData deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    Set<UserData> after = app.user().all();
    //int after = app.user().getUserCount();
    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(deletedUser);
    Assert.assertEquals(before, after);
  }


}
