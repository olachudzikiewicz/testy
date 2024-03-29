package ru.stqa.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter (names = "-c", description = "Group count")
  public int count ;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main (String[] args) throws IOException {
    GroupDataGenerator generator= new GroupDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
        jCommander.usage(); //w razie błędu wyświetli informację o dostępnych opcjach
      return;
      }
    generator.run();
    }



  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    if (format.equals("csv")) {
      saveAsCsv(groups, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(groups, new File(file));
    } else if (format.equals("json")) {
        saveAsJson(groups, new File(file));
    } else {
      System.out.println("Nierozpoznany format: " + format);
    }

  }

  private void saveAsJson(List<GroupData> groups, File file) throws IOException {
   // Gson gson = new Gson();//tak tworząc plik nie jest dobrze sformatowany
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(groups);
    try (Writer writer = new FileWriter(file)) {
      writer.close();
    }
      /* można te trzy linijki zamiast try powyżej
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close(); //zamknięcie pliku */
  }


  private void saveAsXml(List<GroupData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.alias("group", GroupData.class); //zmiana nagłówka z ru.stqa.pft.addressbook.model.GroupData na group
   //można też zamiast linijki wyżej napisać:
    xstream.processAnnotations(GroupData.class); //w klasie GroupData jest: @XStreamAlias("group") sczytuje wszystkie
    // annotacjie zawarte w GroupData.class
    String xml = xstream.toXML(groups);
    try (Writer writer = new FileWriter(file))
    {
      writer.write(xml);
    }
   // writer.close(); //jak dajemy try to nie trzeba zamykać pliku, zamknie się automatycznie
  }

  private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    try (Writer writer = new FileWriter(file))//otwieramy plik do zapisu
    {
      for (GroupData group : groups) {
        writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getFooter()));
      }
    }
  }

  private List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i=1; i<count; i++) {
      groups.add(new GroupData().withName(String.format("Test %s",i)).withHeader(String.format("Header %s",i))
              .withFooter(String.format("Footer %s",i)));
    }
    return groups;
  }
}
