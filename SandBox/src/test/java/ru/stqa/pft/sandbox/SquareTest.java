package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {

  @Test

  public void testArea()
  {
    Square s = new Square(5);
     // assert s.area() == 25;
   // przy użyciu funkcji:
    Assert.assertEquals(s.area(),25.0);
  }
}
