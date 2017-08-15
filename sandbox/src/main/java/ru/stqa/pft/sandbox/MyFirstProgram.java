package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Aleksei");

    double len = 5;
    System.out.println("Площать квадрата со стороной " + len + " = " + area(len));

    double q = 4;
    double z = 6;
    System.out.println("Площать прямоугольника со сторонами " + q + " и " + z + " = " + area(q, z));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}