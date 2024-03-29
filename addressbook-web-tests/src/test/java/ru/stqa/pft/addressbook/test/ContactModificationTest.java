package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test (enabled = false)
  public void testContactModification(){
    app.goTo().goToHome();
    app.getContactHelper().chooseContact();
    app.getContactHelper().chooseUpdateOption();
    app.getContactHelper().fillData(new ContactData("Anna", "Nowak", "222-333-444", "ola@wp.pl", null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
