package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main (String[] args ){
    hello("Ola");

    Square s = new Square(6);
    System.out.println("Pole kwadratu o boku " + s.l + " wynosi: " +area(s));

    Rectangle r = new Rectangle(2,3);
    System.out.println("Pole prostokąta o bokach: "+ r.a + ", " + r.b + " wynosi: " +area(r));

	}

	public static void hello (String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area (Square s) {
	  return s.l * s.l;
  }

  public static double area (Rectangle r) {
	  return r.a * r.b;
  }
}
