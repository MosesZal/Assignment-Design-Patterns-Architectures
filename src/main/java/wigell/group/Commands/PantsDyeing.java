package wigell.group.Commands;

import wigell.group.BusinessObjects.Cloth;
import wigell.group.FrontEnd.Utilities;
import wigell.group.BusinessObjects.Pants;

import java.util.Scanner;

import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class PantsDyeing implements ClothCommand {
  private String [] colors = {"Blue", "Beige"};

  @Override
  public Pants finish(Cloth cloth) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"color\" " +
                         "of your ordered pants from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < colors.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + colors[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner CN = new Scanner(System.in);
      int colorNumber = CN.nextInt();
      if (colorNumber > 0 && colorNumber <= colors.length) {
        cloth.setColor(colors[colorNumber - 1]);
        System.out.println("You chose " + colors[colorNumber - 1] + " as the desired \"color\" for your ordered pants");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + colors.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return (Pants) cloth;
  }
}
