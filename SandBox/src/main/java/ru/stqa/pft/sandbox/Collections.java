package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main (String[] args) {
 // String[] langs = new String[4];
 // langs[0] = "Java";
//  langs[1] = "C#";
//  langs[2] = "Python";
//  langs[3] = "PHP";

    String[] langs = {"Java", "C#", "Python", "PHP"};

    for (String l : langs) {
      System.out.println("Chcę nauczyć się: " + l);
    }

    List<String> languages= new ArrayList<>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");

    List<String> languages1= Arrays.asList("Polski", "Angielski", "Niemiecki");

    for (String l : languages) {
      System.out.println("Umiem: " + l);
    }

    // inny sposób pętli:
    for (int i = 0; i < languages1.size(); i++) {
      System.out.println("Umiem: " + languages1.get(i));
    }

  }
}
