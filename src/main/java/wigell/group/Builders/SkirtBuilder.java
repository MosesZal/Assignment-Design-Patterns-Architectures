package wigell.group.Builders;

import wigell.group.BusinessObjects.Customer;
import wigell.group.BusinessObjects.Pants;
import wigell.group.BusinessObjects.Skirt;
import wigell.group.FrontEnd.Utilities;

import java.util.Scanner;

import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class SkirtBuilder {
  private String [] sizes = {"Medium", "Large"};
  private String [] materials = {"Cotton", "Polyester"};
  private String [] waistlines = {"High", "Natural", "Drop"};
  private String [] patterns = {"A-line", "Pencil", "Maxi"};

  public SkirtBuilder() {
  }

  public SkirtBuilder setIDAndNameAutomatically(Customer customer, Skirt skirt) {
    skirt.incrementID();
    skirt.setName(skirt.generateName(customer));
    return this;
  }

  // In each of the methods below, Utilities.enterToContinue() is commented out. That press enter to continue had made
  // me rage when trying to write tests. I tried really hard to search and figure out how to make the test take 2
  // simulated user inputs. So screw it.
  public SkirtBuilder chooseSize(Skirt skirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"size\" " +
              "of your ordered skirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < sizes.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + sizes[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner SN = new Scanner(System.in);
      int sizeNumber = SN.nextInt();
      if (sizeNumber > 0 && sizeNumber <= sizes.length) {
        skirt.setSize(sizes[sizeNumber - 1]);
        System.out.println("You chose " + sizes[sizeNumber - 1] + " as the desired \"size\" for your ordered skirt");
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

  public SkirtBuilder chooseMaterial(Skirt skirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"material\" " +
              "of your ordered skirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < materials.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + materials[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner MN = new Scanner(System.in);
      int materialNumber = MN.nextInt();
      if (materialNumber > 0 && materialNumber <= materials.length) {
        skirt.setMaterial(materials[materialNumber - 1]);
        System.out.println("You chose " + materials[materialNumber - 1] + " as the desired \"material\" for your ordered skirt");
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

  public SkirtBuilder chooseWaistline(Skirt skirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"waistline\" " +
              "of your ordered skirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < waistlines.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + waistlines[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner WLN = new Scanner(System.in);
      int waistLineNumber = WLN.nextInt();
      if (waistLineNumber > 0 && waistLineNumber <= waistlines.length) {
        skirt.setWaistline(waistlines[waistLineNumber - 1]);
        System.out.println("You chose " + waistlines[waistLineNumber - 1] + " as the desired \"waistline\" for your ordered skirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + waistlines.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public SkirtBuilder choosePattern(Skirt skirt) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"pattern\" " +
              "of your ordered skirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < patterns.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + patterns[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner PN = new Scanner(System.in);
      int patternNumber = PN.nextInt();
      if (patternNumber > 0 && patternNumber <= patterns.length) {
        skirt.setPattern(patterns[patternNumber - 1]);
        System.out.println("You chose " + patterns[patternNumber - 1] + " as the desired \"pattern\" for your ordered skirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + waistlines.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return this;
  }

  public Skirt build(Skirt skirt) {
    if (skirt.getID() != 0 && skirt.getName() != null && skirt.getWaistline() != null && skirt.getPattern() != null
            && skirt.getSize() != null && skirt.getMaterial() != null && skirt.getPrice() != 0)
      return skirt;
    return null;
  }
}
