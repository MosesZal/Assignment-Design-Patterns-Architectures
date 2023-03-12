package wigell.group.Builders;

import wigell.group.BusinessObjects.Customer;
import wigell.group.BusinessObjects.Skirt;
import wigell.group.BusinessObjects.TShirt;
import wigell.group.FrontEnd.Utilities;

import java.util.Scanner;

import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class TShirtBuilder {
  private String [] sizes = {"Medium", "Large"};
  private String [] materials = {"Cotton", "Polyester"};
  private String [] sleeveStyles = {"Short", "Long", "Sleeveless"};
  private String [] neckStyles = {"Crew neck", "V-neck", "Henley neck"};

  public TShirtBuilder() {
  }

  public TShirtBuilder setIDAndNameAutomatically(Customer customer, TShirt tshirt) {
    tshirt.incrementID();
    tshirt.setName(tshirt.generateName(customer));
    return this;
  }

  // In each of the methods below, Utilities.enterToContinue() is commented out. That press enter to continue had made
  // me rage when trying to write tests. I tried really hard to search and figure out how to make the test take 2
  // simulated user inputs. So screw it.
  public TShirtBuilder chooseSize(TShirt tshirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"size\" " +
              "of your ordered t-shirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < sizes.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + sizes[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner SN = new Scanner(System.in);
      int sizeNumber = SN.nextInt();
      if (sizeNumber > 0 && sizeNumber <= sizes.length) {
        tshirt.setSize(sizes[sizeNumber - 1]);
        System.out.println("You chose " + sizes[sizeNumber - 1] + " as the desired \"size\" for your ordered t-shirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + sizes.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public TShirtBuilder chooseMaterial(TShirt tshirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"material\" " +
              "of your ordered t-shirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < materials.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + materials[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner MN = new Scanner(System.in);
      int materialNumber = MN.nextInt();
      if (materialNumber > 0 && materialNumber <= materials.length) {
        tshirt.setMaterial(materials[materialNumber - 1]);
        System.out.println("You chose " + materials[materialNumber - 1] + " as the desired \"material\" for your ordered t-shirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + materials.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public TShirtBuilder chooseSleeveStyle(TShirt tshirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"sleeve style\" " +
              "of your ordered t-shirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < sleeveStyles.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + sleeveStyles[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner SSN = new Scanner(System.in);
      int sleeveStyleNumber = SSN.nextInt();
      if (sleeveStyleNumber > 0 && sleeveStyleNumber <= sleeveStyles.length) {
        tshirt.setSleeveStyle(sleeveStyles[sleeveStyleNumber - 1]);
        System.out.println("You chose " + sleeveStyles[sleeveStyleNumber - 1] + " as the desired \"sleeve style\" for your ordered t-shirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + sleeveStyles.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public TShirtBuilder chooseNeckStyle(TShirt tshirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"neck style\" " +
              "of your ordered t-shirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < neckStyles.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + neckStyles[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner NSN = new Scanner(System.in);
      int neckStyleNumber = NSN.nextInt();
      if (neckStyleNumber > 0 && neckStyleNumber <= neckStyles.length) {
        tshirt.setNeckStyle(neckStyles[neckStyleNumber - 1]);
        System.out.println("You chose " + neckStyles[neckStyleNumber - 1] + " as the desired \"neck style\" for your ordered t-shirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + neckStyles.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public TShirt build(TShirt tshirt) {
    if (tshirt.getID() != 0 && tshirt.getName() != null && tshirt.getNeckStyle() != null && tshirt.getSleeveStyle() != null
            && tshirt.getSize() != null && tshirt.getMaterial() != null && tshirt.getPrice() != 0)
      return tshirt;
    return null;
  }

}
