package ru.stqa.pft.sandbox;

public class Point {
public double x;
public double y;

public Point(double x, double y) {
  this.x = x;
  this.y = y;
}

double distance(Point p) {
  return Math.sqrt(((this.x - p.x)*(this.x - p.x)) + (this.y - p.y)*(this.y-p.y));
}

/*  public static double distance(Point p1, Point p2){
    return Math.sqrt(((p2.x - p1.x)*(p2.x - p1.x)) + (p2.y - p1.y)*(p2.y-p1.y));
  }*/

  public static void main(String[] args) {
    Point p1 = new Point(55,66);
    Point p2 = new Point(33,2);
/* p1.x = 199;
 p1.y = 243;
 p2.x = 337;
 p2.y = 491;
    System.out.println(distance(p1, p2));*/
    System.out.println(p1.distance(p2));

  }

}
