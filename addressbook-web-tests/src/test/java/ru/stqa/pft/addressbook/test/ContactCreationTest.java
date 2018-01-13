package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTest extends TestBase {

  @Test (enabled = false)
  public void testContact() {
    app.goTo().gotoContactPage();
    app.getContactHelper().fillData(new ContactData("Ola", "Nowak", "888-999-000", "ola@wp.pl", "test1"), true);
    app.getContactHelper().submitContactData();
    app.getContactHelper().returnToPage();

  }

  /* Sprawdzanie jaka jest ścieżka i czy plik istnieje
  @Test
  public void testCurrentDir() {
    File currentDir = new File (".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/test1.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
  */
}
