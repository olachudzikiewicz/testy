package ru.stqa.pft.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo; //import nie klasy, a konkretnej metody
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().count(),  equalTo(before.size() + 1)); //sprawdzenie czy rozmiar grupy przed i po się zgadza
    Groups after = app.group().all(); // ładowanie listy ponownie
    assertThat(after,
            equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt())))); //porównanie dwóch obiektów
  }

  @Test
  //sprawdzenie dodania nazwy z apostrofem (jest to zła nazwa)
  public void testGroupBadCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2'");
    app.group().create(group);
    //sprawdzenie czy rozmiar grupy przed i po się zgadza (nazwa z '
    // nie powinna się dodać, więc lista przed i po powinna być taka sama
    assertThat(app.group().count(),  equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after,equalTo(before)); //porównanie dwóch obiektów
  }

}
