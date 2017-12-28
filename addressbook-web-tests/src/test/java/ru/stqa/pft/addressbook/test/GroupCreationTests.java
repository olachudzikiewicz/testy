package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test_max_id", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1); //sprawdzenie czy rozmiar grupy przed i po się zgadza



    int max = 0;
    for (GroupData g:after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);
    before.add(group); //dodanie do starej listy grupę która została stworzona
    //przekształcamy listy w zbiory, żeby móc je porównywać:
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
