package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    //warunki wstępne dla wszystkich testów modyfikacji grupy
    app.goTo().groupPage();
    if (app.group().all().size() == 0) { //sprawdzenie czy jest jakas grupa
      app.group().create(new GroupData().withName("test3"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next(); //wybieramy grupę ze zbioru w losowy sposób
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedGroup);
      Assert.assertEquals(before,after);
  }


}
