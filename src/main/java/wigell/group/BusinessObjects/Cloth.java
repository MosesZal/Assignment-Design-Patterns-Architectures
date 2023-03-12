package wigell.group.BusinessObjects;

import java.beans.PropertyChangeListener;

public interface Cloth {
  void makeItObservable(PropertyChangeListener observer);
  void triggerOrderNotification(boolean ordered);
  void triggerManufactureNotification(boolean manufactured);
  String printReceipt ();

  void setLength(String length);

  void setColor(String color);
}
