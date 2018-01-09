package ru.stqa.pft.addressbook.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next(); //wybieramy grupę ze zbioru w losowy sposób
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedGroup)));

  }


}
