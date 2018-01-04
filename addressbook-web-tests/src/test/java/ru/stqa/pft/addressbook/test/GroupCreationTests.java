package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1); //sprawdzenie czy rozmiar grupy przed i po się zgadza

   /* int max = 0;
    for (GroupData g:after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    } */

 //   group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group); //dodanie do starej listy grupę która została stworzona
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

    //przekształcamy listy w zbiory, żeby móc je porównywać:
    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
