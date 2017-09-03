package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().GetGroupCount();
    app.getGroupHelper().createGroup(new GroupData("test1", "asd", "sss"));
    int after = app.getGroupHelper().GetGroupCount();
    Assert.assertEquals(after, before + 1);
  }

}
