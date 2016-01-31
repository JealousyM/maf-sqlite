package by.perevertkin.mobile;

import java.util.ArrayList;
import java.util.List;

public class UserDC {
  private Users user;
  private List users = new ArrayList();
  private UserAdapter adapter = new UserAdapter();

  public UserDC() {
    super();
    findAll();
  }

  public void setUser(Users user) {
    this.user = user;
  }

  public Users getUser() {
    return user;
  }

  public Users[] getUsers() {
    return (Users[]) users.toArray(new Users[users.size()]);
  }

  public void findAll() {
    users= adapter.findAllUsers();
  }

  public void delete(String name) {
    boolean success = adapter.deleteUser(name);
    if (success) {
      users.remove(user);
    }
  }

  public void insert(Users user) {
    boolean success = adapter.insertUser(user);
    if (success) {
      users.add(user);
    }
  }

  public void update(Users user) {
    boolean success = adapter.updateUser(user);
    if (success) {
      int index = users.indexOf(user);
      users.set(index, user);
    }
  }

  public void prepareUserToAdd() {
    user = new Users();
  }

  public void prepareUserToEdit(Users user) throws CloneNotSupportedException {
    this.user = (Users) user.clone();
  }
}