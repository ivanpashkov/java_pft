package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

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

    List<UserData> before = app.user().list();
    int index = before.size()-1;
    app.user().delete(index);
    List<UserData> after = app.user().list();
    //int after = app.user().getUserCount();
    Assert.assertEquals(after.size(), index);

    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
