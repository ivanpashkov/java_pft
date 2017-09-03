package ru.stqa.pft.addressbook.tests;
//123
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
      int before = app.getGroupHelper().GetGroupCount();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
      }
    app.getGroupHelper().selectGroup(before-1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
      int after = app.getGroupHelper().GetGroupCount();
      Assert.assertEquals(after, before - 1);
    }

}
