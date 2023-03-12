package wigell.group.Commands;

import wigell.group.BusinessObjects.Cloth;
import wigell.group.BusinessObjects.TShirt;
import wigell.group.FrontEnd.Utilities;

import java.util.Scanner;

import static wigell.group.FrontEnd.Utilities.blueText;
import static wigell.group.FrontEnd.Utilities.textColorReset;

public class TShirtDying implements ClothCommand{

  private String [] colors = {"White", "Black"};

  public String[] getColors() {
    return colors;
  }

  @Override
  public TShirt finish(Cloth cloth) {
    while (true) {
      System.out.println("Kindly type the " + blueText + "number " + textColorReset + "corresponding to the desired \"color\" " +
              "of your ordered t-shirt from the options below followed by " + blueText + "(Enter)" + textColorReset);
      for (int x = 0; x < colors.length; x ++)
        System.out.println(blueText + (x + 1) + textColorReset + ". " + colors[x] + ".");
      System.out.print("\nYour choice is: ");
      Scanner CN = new Scanner(System.in);
      int colorNumber = CN.nextInt();
      if (colorNumber > 0 && colorNumber <= colors.length) {
        cloth.setColor(colors[colorNumber - 1]);
        System.out.println("You chose " + colors[colorNumber - 1] + " as the desired \"color\" for your ordered t-shirt");
        //Utilities.enterToContinue();
        break;
      }
      else {
        System.out.println("Please choose from " + blueText + "1 " + textColorReset + "to " + blueText + colors.length + textColorReset);
        Utilities.enterToTryAgain();
      }
    }
    return (TShirt) cloth;
  }
}
