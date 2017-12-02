package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main (String[] args ){
    hello("Ola");
		double l=6;
    System.out.println("Pole kwadratu o boku " +l + " wynosi: " +area(l));
    double a=2,b=8;
    System.out.println("Pole prostokąta o bokach: "+ a + ", " + b + " wynosi: " +area(a,b));

	}

	public static void hello (String somebody) {
    System.out.println("Hello " + somebody + "!");
  }

  public static double area (double l) {
	  return l*l;
  }

  public static double area (double a, double b) {
	  return a*b;
  }
}
