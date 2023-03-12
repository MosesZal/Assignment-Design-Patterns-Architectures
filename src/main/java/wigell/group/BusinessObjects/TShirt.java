package wigell.group.BusinessObjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

import static wigell.group.FrontEnd.Utilities.textColorReset;

public class TShirt implements Cloth{
  // Properties
  private PropertyChangeSupport propertyChangeSupport;
  private int ID = 0;
  private String name;
  private String sleeveStyle;
  private String neckStyle;
  private String size;
  private String material;
  private String color;
  private boolean ordered = false;
  private boolean manufactured = false;
  private final int price = 149;

  // Constructor
  public TShirt() {
  }

  // Generated Getters & Setters
  public PropertyChangeSupport getPropertyChangeSupport() {
    return propertyChangeSupport;
  }

  public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
    this.propertyChangeSupport = propertyChangeSupport;
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

  public String getSleeveStyle() {
    return sleeveStyle;
  }

  public void setSleeveStyle(String sleeveStyle) {
    this.sleeveStyle = sleeveStyle;
  }

  public String getNeckStyle() {
    return neckStyle;
  }

  public void setNeckStyle(String neckStyle) {
    this.neckStyle = neckStyle;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getColor() {
    return color;
  }

  @Override
  public void setColor(String color) {
    this.color = color;
  }

  public boolean isOrdered() {
    return ordered;
  }

  public void setOrdered(boolean ordered) {
    this.ordered = ordered;
  }

  public boolean isManufactured() {
    return manufactured;
  }

  public void setManufactured(boolean manufactured) {
    this.manufactured = manufactured;
  }

  public int getPrice() {
    return price;
  }

  // Methods
  public void incrementID() {
    ID ++;
  }

  public String generateName(Customer customer) {
    name = customer.getName() + "'s " + getClass().getSimpleName().toLowerCase();
    return name;
  }

  @Override
  public void makeItObservable(PropertyChangeListener observer) {
    this.propertyChangeSupport = new PropertyChangeSupport(this);
    propertyChangeSupport.addPropertyChangeListener(observer);
  }

  @Override
  public void triggerOrderNotification(boolean ordered) {
    boolean oldBoolean = this.ordered;
    setOrdered(ordered);
    propertyChangeSupport.firePropertyChange("ordered", oldBoolean, this.ordered);
  }

  @Override
  public void triggerManufactureNotification(boolean manufactured) {
    boolean oldBoolean = this.manufactured;
    setManufactured(manufactured);
    propertyChangeSupport.firePropertyChange("manufactured", oldBoolean, this.manufactured);
  }

  @Override
  public String toString() {
    if (manufactured)
      return name + " production is complete and ready for delivery!" + textColorReset;
    else if (ordered) {
      String [] nameDetails = name.split("'s ");
      return nameDetails[0] + " has just ordered a new " + nameDetails[1] + "!" + textColorReset;
    }
    return null;
  }

  @Override
  public String printReceipt() {
    String [] nameDetails = name.split("'s ");
    return "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWigell Group" +
            "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  RECEIPT" +
            "\n    Item: " + this.getClass().getSimpleName() +
            "\nCustomer: " + nameDetails[0] +
            "\n Details: " + "Size - " + size +
            "\n\t\t  Material - " + material +
            "\n\t\t  Sleeve Style - " + sleeveStyle +
            "\n\t\t  Neck Style - " + neckStyle +
            "\n\t\t  Color - " + color +
            "\n\n    Date: " + LocalDate.now() +
            "\n   Price: " + price + " SEK";
  }

  @Override
  public void setLength(String length) {
  }


}
