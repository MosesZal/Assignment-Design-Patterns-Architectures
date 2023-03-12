package wigell.group.BusinessObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static wigell.group.FrontEnd.Utilities.textColorReset;

class TShirtTest {
  @Test
  void testThatIncrementIdIsWorkingProperly() {
    TShirt tShirt = new TShirt();
    tShirt.incrementID();
    assertEquals(1, tShirt.getID());
  }

  @Test
  void testThatGenerateNameIsWorkingProperly() {
    TShirt tShirt = new TShirt();
    Customer customer = new Customer();
    customer.setName("Zouzou");
    assertEquals("Zouzou's tshirt", tShirt.generateName(customer));
  }

  @Test
  void testThatToStringIsWorkingProperlyBecauseItsModified() {
    TShirt tShirt = new TShirt();
    tShirt.setName("Zouzou's t-shirt");
    tShirt.setManufactured(true);
    assertEquals( "Zouzou's t-shirt production is complete and ready for delivery!" + textColorReset,
            tShirt.toString());
  }

  @Test
  void testMakeItObservableIsWorking() {
    TShirt tShirt = new TShirt();
    CEO ceo = new CEO();
    tShirt.makeItObservable(ceo);
    assertSame(tShirt.getPropertyChangeSupport().getPropertyChangeListeners()[0], ceo);
  }

}