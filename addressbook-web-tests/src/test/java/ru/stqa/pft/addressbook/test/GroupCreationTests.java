package ru.stqa.pft.addressbook.test;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo; //import nie klasy, a konkretnej metody
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
   // List<Object[]> list = new ArrayList<Object[]>(); //do csv
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));
    String xml = "";
    String line = reader.readLine(); //czyta pierwszą linijkę
    //do csv:
   /* while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();
    } */
   //do xml:
    while (line != null) {
      xml+=line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    ////////////////
 //   return list.iterator(); //do csv
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
   try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
     String json = "";
     String line = reader.readLine(); //czyta pierwszą linijkę
     while (line != null) {
       json += line;
       line = reader.readLine();
     }
     Gson gson = new Gson();
     List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
     }.getType());
     return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
   }
   //używając try reader się automatycznie zamyka
  }


  @Test (dataProvider = "validGroupsFromJson")
  public void testGroupCreation(GroupData group) {
    app.goTo().groupPage();
    Groups before = app.group().all();
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
