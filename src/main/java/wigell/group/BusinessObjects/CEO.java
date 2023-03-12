package wigell.group.BusinessObjects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class CEO implements PropertyChangeListener {
  private int ID = 0;
  private String name;

  public CEO() {
  }

  public CEO(String name) {
    ID ++;
    this.name = name;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    if (event.getPropertyName().equals("ordered"))
      System.out.println("\u001B[33m" + "Message for " + this.getName() + ": " + event.getSource().toString());
    else if (event.getPropertyName().equals("manufactured"))
      System.out.println("\u001B[32m" + "Message for " + this.getName() + ": " + event.getSource().toString());
  }
}
