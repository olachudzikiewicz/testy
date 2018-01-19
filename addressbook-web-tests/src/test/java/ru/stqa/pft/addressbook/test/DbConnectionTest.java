package ru.stqa.pft.addressbook.test;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;

public class DbConnectionTest {

  @Test
  public void testDbConnection() throws SQLException {

    Connection conn = null;

    try {
      conn =
              DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");

    //Tworzymy obiekt typu Statement, żeby wyciągnąć z bazy danych informacje
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
    Groups groups = new Groups();
    while (rs.next()) { //dopóki są jakieś dane w rs
      groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
              .withFooter(rs.getString("group_footer")).withHeader(rs.getString("group_header")));
    }
    //zwalnianie pamięci
    rs.close();
    st.close();
    conn.close();
    ///
    System.out.println(groups);



      // Do something with the Connection

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}
