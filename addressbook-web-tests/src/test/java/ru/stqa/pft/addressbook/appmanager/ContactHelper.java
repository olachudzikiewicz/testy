package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.NoSuchElementException;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

//boolean creation - przekazujemy czy jest to tworzenie nowego kontaktu (T) czy modyfikacja (F)
  public void fillData(ContactData contactData, boolean creation) {
    type(By.name("firstname"),contactData.getName());
    type(By.name("lastname"),contactData.getSurname());
    type(By.name("home"),contactData.getPhoneNumber());
    type(By.name("email"),contactData.getEmail());

    if  (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group"))); //sprawdzamy brak rozwijanej listy z grupą
    }
  }

  public void submitContactData() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void returnToPage() {
    click(By.xpath("//div/div[4]/div/i/a[2]"));
  }

  public void chooseContact() {
    click(By.name("selected[]"));
  }

  public void chooseUpdateOption() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
}
