package wigell.group.Builders;

import wigell.group.BusinessObjects.Customer;
import wigell.group.BusinessObjects.Pants;
import wigell.group.FrontEnd.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class PantsBuilder {

  private String [] types = {"Jeans", "Dress pants", "Sweatpants"};
  private String [] fits = {"Slim", "Regular", "Athletic"};
  private String [] materials = {"Cotton", "Denim"};
  private String [] sizes = {"Medium", "Large"};

  // Constructor
  public PantsBuilder() {
  }

  public PantsBuilder setIDAndNameAutomatically(Customer customer, Pants pants) {
    pants.incrementID();
    pants.setName(pants.generateName(customer));
    return this;
  }

  // In each of the methods below, Utilities.enterToContinue() is commented out. That press enter to continue had made
  // me rage when trying to write tests. I tried really hard to search and figure out how to make the test take 2
  // simulated user inputs. So screw it.
  public PantsBuilder chooseSize(Pants pants) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"size\" " +
                         "of your ordered pants from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < sizes.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + sizes[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner SN = new Scanner(System.in);
      int sizeNumber = SN.nextInt();
      if (sizeNumber > 0 && sizeNumber <= sizes.length) {
        pants.setSize(sizes[sizeNumber - 1]);
        System.out.println("You chose " + sizes[sizeNumber - 1] + " as the desired \"size\" for your ordered pants");
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

  public PantsBuilder chooseMaterial(Pants pants) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"material\" " +
                         "of your ordered pants from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < materials.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + materials[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner MN = new Scanner(System.in);
      int materialNumber = MN.nextInt();
      if (materialNumber > 0 && materialNumber <= materials.length) {
        pants.setMaterial(materials[materialNumber - 1]);
        System.out.println("You chose " + materials[materialNumber - 1] + " as the desired \"material\" for your ordered pants");
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

  public PantsBuilder chooseType(Pants pants) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"type\" " +
                         "of your ordered pants from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < types.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + types[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner TN = new Scanner(System.in);
      int typeNumber = TN.nextInt();
      if (typeNumber > 0 && typeNumber <= types.length) {
        pants.setType(types[typeNumber - 1]);
        System.out.println("You chose " + types[typeNumber - 1] + " as the desired \"type\" for your ordered pants");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + types.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public PantsBuilder chooseFit(Pants pants) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"fit\" " +
                         "of your ordered pants from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < fits.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + fits[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner FN = new Scanner(System.in);
      int fitNumber = FN.nextInt();
      if (fitNumber > 0 && fitNumber <= fits.length) {
        pants.setFit(fits[fitNumber - 1]);
        System.out.println("You chose " + fits[fitNumber - 1] + " as the desired \"fit\" for your ordered pants");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + fits.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public Pants build(Pants pants) {
    if (pants.getID() != 0 && pants.getName() != null && pants.getType() != null && pants.getFit() != null
        && pants.getSize() != null && pants.getMaterial() != null && pants.getPrice() != 0)
      return pants;
    return null;
  }
}
