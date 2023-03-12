package wigell.group.FrontEnd;

import wigell.group.Builders.PantsBuilder;
import wigell.group.Builders.SkirtBuilder;
import wigell.group.Builders.TShirtBuilder;
import wigell.group.BusinessObjects.*;
import wigell.group.Commands.ClothInvoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class OnlineStoreMenu {
  private Customer user;
  private List<Customer> customers = new ArrayList<>();
  ClothInvoker invoker = new ClothInvoker();
  PantsBuilder PB = new PantsBuilder();
  TShirtBuilder TB = new TShirtBuilder();
  SkirtBuilder SB = new SkirtBuilder();

  public OnlineStoreMenu() {
  }

  public Customer getUser() {
    return user;
  }

  public void setUser(Customer user) {
    this.user = user;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public void accessOnlineStore() {
    boolean accessSuccessful = false;
    while (!accessSuccessful) {
      startScreen();
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();
      if (choice == 1) {
        System.out.println("Please login into your account with your e-mail and password\n");
        System.out.print("E-mail: ");
        Scanner accountInformation = new Scanner(System.in);
        String email = accountInformation.nextLine();
        System.out.print("Password: ");
        String password = accountInformation.nextLine();
        for (Customer existingCustomer : customers) {
          if (existingCustomer.getEmail().equals(email)) {
            user = existingCustomer;
            accessSuccessful = true;
          }
        }
        if (!accessSuccessful) {
          loginFailedScreen();
        }
      }
      else if (choice == 2) {
        System.out.println("Please fill in your personal information to create an account");
        Scanner accountInformation = new Scanner(System.in);
        System.out.print("Full name: ");
        String name = accountInformation.nextLine();
        System.out.print("Address: ");
        String address = accountInformation.nextLine();
        System.out.print("E-mail: ");
        String email = accountInformation.nextLine();
        System.out.print("Password: ");
        String password = accountInformation.nextLine();
        user = new Customer(name, address, email, password, this);
        System.out.println("\nYour account was successfully created!");
        accessSuccessful = true;
      }
      else {
        System.out.println("Invalid choice!");
        Utilities.enterToTryAgain();
      }
    }
  }

  public void startScreen() {
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t☺ Welcome to Wigell Group's \"clothes-on-demand\" online store ☺");
    System.out.println("Please choose the " + blueText + "number " + textColorReset + "corresponding to the desired action " +
                       "followed by " + blueText + "(Enter)" + textColorReset + ".");
    System.out.println(blueText + 1 + textColorReset + ". Login with existing account.");
    System.out.println(blueText + 2 + textColorReset + ". Signup.");
    System.out.println("Your choice is: ");
  }

  public void loginFailedScreen() {
    System.out.println("We're sorry! It appears that your e-mail isn't associated with an account");
    System.out.println("Please signup inorder to create a new account");
    System.out.println("Press " + blueText + "(Enter)" + textColorReset + " to go back to the previous screen");
    Scanner E = new Scanner(System.in);
    String enter = E.nextLine();
  }

  public void ordering(CEO tom) {

    boolean logoutSelected = false;
    while (!logoutSelected) {
      orderScreen();
      Scanner OO = new Scanner(System.in);
      int orderOption = OO.nextInt();
      switch (orderOption) {
        case 1 -> {
          System.out.println("Please follow the instructions on screen to customize your own pants.");
          Pants pants = new Pants();
          PB.setIDAndNameAutomatically(user, pants).chooseSize(pants).chooseMaterial(pants).chooseType(pants).chooseFit(pants).build(pants);
          invoker.execute(pants, tom);
        }
        case 2 -> {
          System.out.println("Please follow the instructions on screen to customize your own t-shirt.");
          TShirt tshirt = new TShirt();
          TB.setIDAndNameAutomatically(user, tshirt).chooseSize(tshirt).chooseMaterial(tshirt).chooseSleeveStyle(tshirt).chooseNeckStyle(tshirt).build(tshirt);
          invoker.execute(tshirt, tom);
        }
        case 3 -> {
          System.out.println("Please follow the instructions on screen to customize your own skirt.");
          Skirt skirt = new Skirt();
          SB.setIDAndNameAutomatically(user, skirt).chooseSize(skirt).chooseMaterial(skirt).chooseWaistline(skirt).choosePattern(skirt).build(skirt);
          invoker.execute(skirt, tom);
        }
        case 4 -> {
          user = null;
          logoutSelected = true;
        }
        default -> {
          System.out.println("Invalid option!");
          Utilities.enterToTryAgain();
        }
      }
    }
  }

  public void orderScreen() {
    System.out.println("Welcome " + user.getName() + "!");
    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t You're few steps away from ordering and customizing your own cloth!");
    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tPlease choose the " + blueText + "number " + textColorReset + "corresponding " +
                       "to your desired cloth you would like to order!");
    System.out.println(blueText + 1 + textColorReset + ". Pants.");
    System.out.println(blueText + 2 + textColorReset + ". T-Shirt.");
    System.out.println(blueText + 3 + textColorReset + ". Skirt.");
    System.out.println("\n\n" + blueText + 4 + textColorReset + ". Logout!");
    System.out.println("\nYour choice is: ");
  }
}
