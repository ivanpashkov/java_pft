package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testArea() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(3, 4);
    Assert.assertEquals(p1.distance(p2), 2.8284271247461903);

    Point p3 = new Point(10, 20);
    Point p4 = new Point(63, 97);
    Assert.assertEquals(p3.distance(p4), 93.4, 0.1);
  }

    @Test
    public void testArea1() {
      Point p5 = new Point(55, 66);
      Point p6 = new Point(33, 2);
      Assert.assertEquals(p5.distance(p6), 67.67569726275453);
    }
  }
