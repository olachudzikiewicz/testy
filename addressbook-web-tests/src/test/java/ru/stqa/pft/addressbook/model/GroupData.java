package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@XStreamAlias("group")
@Entity //wskazówka dla hibernate o powiązaniu GroupData z tabelą group_list (trzeba też wpisać mapowanie w pliku
// konfiguracyjnym)
@Table(name = "group_list")
public class GroupData {

@XStreamOmitField //ma pominąć w generacji xml pole poniżej
@Id
@Column(name = "group_id") //piszemy jakiej kolumnie w bazie odpowiada poniższe pole, piszemy tylko jak nazwy są różne
  private  int id = Integer.MAX_VALUE;;

  @Expose //dla json określamy co ma się zapisywać do pliku
  @Column(name = "group_name")
  private  String name;

  @Expose
  @Column(name = "group_header")
  @Type(type = "text") //dodajemy bo jest to pole wielowierszowe
  private  String header;

  @Expose
  @Column(name = "group_footer")
  @Type(type = "text")
  private  String footer;

  public int getId() {
    return id;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }


}
