package ru.stqa.pft.addressbook.tests;
//123
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.TestBase;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().deleteSelectedGroups();
     app.getGroupHelper().returnToGroupPage();
    }

}
