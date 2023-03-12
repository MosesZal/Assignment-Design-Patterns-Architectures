package wigell.group.BusinessObjects;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.*;
import static wigell.group.FrontEnd.Utilities.textColorReset;

class PantsTest {

  @Test
  void testThatIncrementIdIsWorkingProperly() {
    Pants pants = new Pants();
    pants.incrementID();
    assertEquals(1, pants.getID());
  }

  @Test
  void testThatGenerateNameIsWorkingProperly() {
    Pants pants = new Pants();
    Customer customer = new Customer();
    customer.setName("Miko");
    assertEquals("Miko's pants", pants.generateName(customer));
  }

  @Test
  void testThatToStringIsWorkingProperlyBecauseItsModified() {
    Pants pants = new Pants();
    pants.setName("Invisible pants");
    pants.setManufactured(true);
    assertEquals( "Invisible pants production is complete and ready for delivery!" + textColorReset,
                 pants.toString());
  }

  @Test
  void testMakeItObservableIsWorking() {
    Pants pants = new Pants();
    CEO ceo = new CEO("Matt");
    pants.makeItObservable(ceo);
    assertSame(pants.getPropertyChangeSupport().getPropertyChangeListeners()[0], ceo);
  }


}