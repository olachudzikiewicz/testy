package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase.class); //zmienna jest tworzona nie przy
  // użyciu konstruktora a za pomocą loggerFactory

//  protected static  final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
  //określenie w konfiguracji testu (w polu VM Options dopisujemy : -Dbrowser=chrome, jak nie ustalimy w
// konfiguracji: BrowserType.FIREFOX - domyślna,
protected static  final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


  @BeforeMethod
  public void logTestStart(Method m, Object[] p) {
    logger.info("Start test " + m.getName() + "with parameters " + Arrays.asList(p));
  }

  @AfterMethod (alwaysRun = true) //jak test padnie, to to nam gwarantuje, że się log zapisze
  public void logTestStop(Method m) {
    logger.info("Stop test " + m.getName());
  }
}
