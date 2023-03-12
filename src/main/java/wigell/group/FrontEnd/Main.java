package wigell.group.FrontEnd;

import wigell.group.BusinessObjects.CEO;
import wigell.group.BusinessObjects.Customer;

public class Main {
  public static void main(String[] args) {
    CEO tom = new CEO("Tomas Wigell");
    OnlineStoreMenu menu = new OnlineStoreMenu();
    Customer customer = new Customer("Moussa Zalzala", "Karlskoga", "moussa.zalzala@hotmail.com",
                                     "whatever", menu);
    while (true) {
      menu.accessOnlineStore();
      menu.ordering(tom);
    }
  }
}