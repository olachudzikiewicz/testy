package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void login(String username, String password) {
    type(By.name("user"),username);
    type(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
   // wd.findElement(By.name("user")).click();
    //wd.findElement(By.name("user")).sendKeys("\\undefined");
   // wd.findElement(By.name("pass")).click();
//    wd.findElement(By.id("LoginForm")).click();
   // wd.findElement(By.name("user")).click();
   // wd.findElement(By.name("user")).clear();
   // wd.findElement(By.name("user")).sendKeys(username);
   // wd.findElement(By.name("pass")).click();
   // wd.findElement(By.name("pass")).clear();
   // wd.findElement(By.name("pass")).sendKeys(password);
   // wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }
}
