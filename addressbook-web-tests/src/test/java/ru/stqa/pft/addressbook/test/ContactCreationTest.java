package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test (enabled = false)
  public void testContact() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillData(new ContactData("Ola", "Nowak", "888-999-000", "ola@wp.pl", "test1"), true);
    app.getContactHelper().submitContactData();
    app.getContactHelper().returnToPage();

  }
}
