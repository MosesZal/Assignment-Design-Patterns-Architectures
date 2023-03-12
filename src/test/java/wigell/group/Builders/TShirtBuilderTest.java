package wigell.group.Builders;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Customer;
import wigell.group.BusinessObjects.Skirt;
import wigell.group.BusinessObjects.TShirt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class TShirtBuilderTest {
  @Test
  void testSetIDAndNameGeneratedEqualsExpectedValues() {
    Customer customer = new Customer();
    customer.setName("Moussa");
    TShirtBuilder TB = new TShirtBuilder();
    TShirt tShirt = new TShirt();
    TB.setIDAndNameAutomatically(customer, tShirt);
    assertEquals(1, tShirt.getID());
    assertEquals("Moussa's tshirt", tShirt.getName());
  }

  @Test
  void testChosenSizeIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);

    TShirtBuilder TB = new TShirtBuilder();
    TShirt tShirt = new TShirt();
    TB.chooseSize(tShirt);
    assertNotNull(tShirt.getSize());

    System.setIn(sysInBackup);
  }

  @Test
  void testChosenMaterialIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("2".getBytes());
    System.setIn(optionSimulator);

    TShirtBuilder TB = new TShirtBuilder();
    TShirt tShirt = new TShirt();
    TB.chooseMaterial(tShirt);
    assertNotNull(tShirt.getMaterial());

    System.setIn(sysInBackup);
  }

  @Test
  void testChosenWaistLineIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("3".getBytes());
    System.setIn(optionSimulator);

    TShirtBuilder TB = new TShirtBuilder();
    TShirt tShirt = new TShirt();
    TB.chooseSleeveStyle(tShirt);
    assertNotNull(tShirt.getSleeveStyle());

    System.setIn(sysInBackup);
  }

  @Test
  void testChooseNeckStyleThrowsAnExceptionIfLetterIsSelected() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("a".getBytes());
    System.setIn(optionSimulator);

    TShirtBuilder TB = new TShirtBuilder();
    assertThrows(InputMismatchException.class, () -> TB.chooseNeckStyle(new TShirt()));

    System.setIn(sysInBackup);
  }

  @Test
  void TestThatBuildMethodReturnsAnObjectIfTheConditionIsMet() {
    Customer customer = new Customer();
    customer.setName("Moussa");
    TShirtBuilder TB = new TShirtBuilder();
    TShirt tShirt = new TShirt();
    TB.setIDAndNameAutomatically(customer, tShirt);

    InputStream sysInBackup = System.in;
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);
    TB.chooseSize(tShirt);
    ByteArrayInputStream optionSimulator2 = new ByteArrayInputStream("2".getBytes());
    System.setIn(optionSimulator2);
    TB.chooseMaterial(tShirt);
    ByteArrayInputStream optionSimulator3 = new ByteArrayInputStream("3".getBytes());
    System.setIn(optionSimulator3);
    TB.chooseSleeveStyle(tShirt);
    ByteArrayInputStream optionSimulator4 = new ByteArrayInputStream("3".getBytes());
    System.setIn(optionSimulator4);
    TB.chooseNeckStyle(tShirt);
    System.setIn(sysInBackup);
    assertNotNull(TB.build(tShirt));
  }
}