package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTest {

  @Test
  public void testArea() {
    Rectangle r = new Rectangle(1, 2);
    Assert.assertEquals(r.area(), 2.0);
  }

}
