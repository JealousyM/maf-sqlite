package by.perevertkin.mobile;


import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.util.Utility;

public class UserAdapter extends DBAdapter {
  public UserAdapter() {
    super();
  }

  public List findAllUsers() {
    List users = new ArrayList();

    try {
      ResultSet result = executeQuery("SELECT  NAME,SURNAME,MAIL,AGE FROM USERS;");

      while (result.next()) {
        Users user = new Users();
        user.setName(result.getString("NAME"));
        user.setSurname(result.getString("SURNAME"));
        user.setMail(result.getString("MAIL"));
        user.setAge(new Double(result.getDouble("AGE")));
        users.add(user);
        Utility.ApplicationLogger.severe("User: " + user.getName() + "," +
                                         user.getSurname() + "," + user.getMail() + "," +
                                         user.getAge());
      }

    } catch (Exception ex) {
      Utility.ApplicationLogger.severe(ex.getMessage());
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }

    return users;
  }

  public boolean insertUser(Users user) {
    return executeUpdate("INSERT INTO USERS (NAME,SURNAME,MAIL,AGE) VALUES (" +
                         user.getName() + ",'" + user.getSurname() + "','" +
                         user.getMail() + "','" + user.getAge() + "')");
  }

  public boolean deleteUser(String name) {
    return executeUpdate("DELETE FROM USERS WHERE USER=" + name);
  }

  public boolean updateUser(Users user) {
    return executeUpdate("UPDATE USERS SET NAME='" + user.getName() + "', SURNAME='" +
                         user.getSurname() + "', MAIL='" + user.getMail() + "' WHERE NAME=" +
                         user.getName());
  }
}