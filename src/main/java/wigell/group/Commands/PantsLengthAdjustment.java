package wigell.group.Commands;


import wigell.group.BusinessObjects.Cloth;
import wigell.group.FrontEnd.Utilities;
import wigell.group.BusinessObjects.Pants;

import java.util.Scanner;

import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class PantsLengthAdjustment implements ClothCommand {
  private String [] lengths = {"Full", "Ankle", "Capri"};

  @Override
  public Pants finish (Cloth cloth) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"length\" " +
                         "of your ordered cloth from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < lengths.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + lengths[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner LN = new Scanner(System.in);
      int lengthNumber = LN.nextInt();
      if (lengthNumber > 0 && lengthNumber <= lengths.length) {
        cloth.setLength(lengths[lengthNumber - 1]);
        System.out.println("You chose " + lengths[lengthNumber - 1] + " as the desired \"length\" for your ordered cloth");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + lengths.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return (Pants) cloth;
  }
}
