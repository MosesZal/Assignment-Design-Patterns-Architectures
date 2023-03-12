package wigell.group.BusinessObjects;

import wigell.group.FrontEnd.OnlineStoreMenu;

public class Customer {
  // Properties
  private int ID = 0;
  private String name;
  private String address;
  private String email;
  private String password;


  // Constructors
  public Customer() {
  }

  public Customer(String name, String address, String email, String password, OnlineStoreMenu menu) {
    ID ++;
    this.name = name;
    this.address = address;
    this.email = email;
    this.password = password;
    menu.getCustomers().add(this);
  }

  // Generated getters & setters
  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
