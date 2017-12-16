package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContact() {
      app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillData(new ContactData("Ola", "Nowak", "888-999-000", "ola@op.pl"));
    app.getContactHelper().submitContactData();
    app.getContactHelper().returnToPage();

  }
}
