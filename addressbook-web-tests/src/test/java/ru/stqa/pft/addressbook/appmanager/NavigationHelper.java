package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups") &&
            isElementPresent(By.name("new"))) //sprawdzenie czy trzeba przechodzić na tą stronę czy na niej jesteśmy
    {
 return; //oznacza że już jesteśmy na stronie groups więc nic nie robimy
    }
      click(By.linkText("groups"));

  }

  public void gotoContactPage() {
    click(By.linkText("add new"));
  }

  public void goToHome() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }
}
