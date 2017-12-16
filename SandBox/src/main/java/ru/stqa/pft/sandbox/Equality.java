package ru.stqa.pft.sandbox;

public class Equality {

  public static void main (String[] args) {
    String s1 = "Firefox";
    String s2 = new String(s1);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

    String s3 = "Firefox";
    String s4 = s3;

    System.out.println(s3 == s4);
    System.out.println(s3.equals(s4));

    String s5 = "Firefox";
    String s6 = "Firefox";

    System.out.println(s5 == s6);
    System.out.println(s5.equals(s6));

  }
}
