package ru.stqa.pft.addressbook.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //wskazówka dla hibernate o powiązaniu GroupData z tabelą group_list
@Table(name = "addressbook")
public class ContactData {

  private final String name;
  private final String surname;
  private final String phoneNumber;
  private final String email;
  private String group;

  public ContactData(String name, String surname, String phoneNumber, String email, String group) {
    this.name = name;
    this.surname = surname;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
