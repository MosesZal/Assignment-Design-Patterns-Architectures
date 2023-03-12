package wigell.group.FrontEnd;

import java.util.Scanner;

public class Utilities {
  public static final String blueText = "\u001B[34m";
  public static final String textColorReset = "\u001B[0m";

  public static void enterToTryAgain() {
    System.out.println("Press " + blueText + "(Enter) " + textColorReset + "to try again!");
    Scanner E = new Scanner(System.in);
    String enter = E.nextLine();
  }

  // The usages of this method were all commented out because I couldn't figure out how to include in the testing classes
  // Its usage required making the testing methods take 2 simulated user inputs in the same method
  public static void enterToContinue() {
    System.out.println("Press " + blueText + "(Enter) " + textColorReset + "to continue!");
    Scanner E = new Scanner(System.in);
    String enter = E.nextLine();
  }
}
