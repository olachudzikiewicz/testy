package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main (String[] args ){
    hello("Ola");

    Square s = new Square(6);
    System.out.println("Pole kwadratu o boku " + s.l + " wynosi: " + s.area());

    Rectangle r = new Rectangle(2,3);
    System.out.println("Pole prostokąta o bokach: "+ r.a + ", " + r.b + " wynosi: " + r.area());

	}

	public static void hello (String somebody) {
    System.out.println("Hello " + somebody + "!");
  }


}
