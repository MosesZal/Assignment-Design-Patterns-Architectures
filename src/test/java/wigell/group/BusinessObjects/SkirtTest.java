package wigell.group.BusinessObjects;

import org.junit.jupiter.api.Test;
import wigell.group.Builders.SkirtBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static wigell.group.FrontEnd.Utilities.textColorReset;

class SkirtTest {
  @Test
  void testThatIncrementIdIsWorkingProperly() {
    Skirt skirt = new Skirt();
    skirt.incrementID();
    assertEquals(1, skirt.getID());
  }

  @Test
  void testThatGenerateNameIsWorkingProperly() {
    Skirt skirt = new Skirt();
    Customer customer = new Customer();
    customer.setName("Miko");
    assertEquals("Miko's skirt", skirt.generateName(customer));
  }

  @Test
  void testThatToStringIsWorkingProperlyBecauseItsModified() {
    Skirt skirt = new Skirt();
    skirt.setName("Bonnie's skirt");
    skirt.setOrdered(true);
    assertEquals( "Bonnie has just ordered a new skirt!" + textColorReset,
            skirt.toString());
  }

  @Test
  void testMakeItObservableIsWorking() {
    Skirt skirt = new Skirt();
    CEO ceo = new CEO();
    skirt.makeItObservable(ceo);
    assertSame(skirt.getPropertyChangeSupport().getPropertyChangeListeners()[0], ceo);
  }

}