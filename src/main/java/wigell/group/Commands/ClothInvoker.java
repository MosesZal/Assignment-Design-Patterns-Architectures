package wigell.group.Commands;

import wigell.group.BusinessObjects.*;

import java.util.ArrayList;
import java.util.List;

public class ClothInvoker {
  private List <ClothCommand> commands = new ArrayList<>();

  public List<ClothCommand> getCommands() {
    return commands;
  }

  public void checkCommandsList() {
    if (commands.isEmpty()) {
      commands.add(new PantsLengthAdjustment());
      commands.add(new PantsDyeing());
      commands.add(new TShirtDying());
      commands.add(new SkirtDyeing());
    }
  }

  public Cloth execute (Cloth cloth, CEO tom) {
    checkCommandsList();
    if (cloth instanceof Pants) {
      for (ClothCommand theCommand : commands)
        if (theCommand instanceof PantsLengthAdjustment || theCommand instanceof PantsDyeing)
          theCommand.finish(cloth);
    }
    else if (cloth instanceof TShirt) {
      for (ClothCommand theCommand : commands)
        if (theCommand instanceof TShirtDying)
          theCommand.finish(cloth);
    }
    else if (cloth instanceof Skirt) {
      for (ClothCommand theCommand : commands)
        if (theCommand instanceof SkirtDyeing)
          theCommand.finish(cloth);
    }

    cloth.makeItObservable(tom);
    cloth.triggerOrderNotification(true);
    try {
      Thread.sleep(7000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    cloth.triggerManufactureNotification(true);
    System.out.println(cloth.printReceipt());
    return cloth;
  }


}
