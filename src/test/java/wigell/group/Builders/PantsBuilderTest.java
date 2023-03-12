package wigell.group.Builders;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Customer;
import wigell.group.BusinessObjects.Pants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class PantsBuilderTest {
  @Test
  void testSetIDAndNameGeneratedEqualsExpectedValues() {
    Customer customer = new Customer();
    customer.setName("Moussa");
    PantsBuilder PB = new PantsBuilder();
    Pants pants = new Pants();
    PB.setIDAndNameAutomatically(customer, pants);
    assertEquals(1, pants.getID());
    assertEquals("Moussa's pants", pants.getName());
  }

  @Test
  void testChosenSizeIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);

    PantsBuilder PB = new PantsBuilder();
    Pants pants = new Pants();
    PB.chooseSize(pants);
    assertNotNull(pants.getSize());

    System.setIn(sysInBackup);
  }

  @Test
  void testChosenMaterialIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("2".getBytes());
    System.setIn(optionSimulator);

    PantsBuilder PB = new PantsBuilder();
    Pants pants = new Pants();
    PB.chooseMaterial(pants);
    assertNotNull(pants.getMaterial());

    System.setIn(sysInBackup);
  }

  @Test
  void testChosenTypeIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("3".getBytes());
    System.setIn(optionSimulator);

    PantsBuilder PB = new PantsBuilder();
    Pants pants = new Pants();
    PB.chooseType(pants);
    assertNotNull(pants.getType());

    System.setIn(sysInBackup);
  }

  @Test
  void testChooseFitThrowsAnExceptionIfLetterIsSelected() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("a".getBytes());
    System.setIn(optionSimulator);

    PantsBuilder PB = new PantsBuilder();
    assertThrows(InputMismatchException.class, () -> PB.chooseFit(new Pants()));

    System.setIn(sysInBackup);
  }

  @Test
  void TestThatBuildMethodReturnsAnObjectIfTheConditionIsMet() {
    Customer customer = new Customer();
    customer.setName("Moussa");
    PantsBuilder PB = new PantsBuilder();
    Pants pants = new Pants();
    PB.setIDAndNameAutomatically(customer, pants);

    InputStream sysInBackup = System.in;
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);
    PB.chooseSize(pants);
    ByteArrayInputStream optionSimulator2 = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator2);
    PB.chooseMaterial(pants);
    ByteArrayInputStream optionSimulator3 = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator3);
    PB.chooseType(pants);
    ByteArrayInputStream optionSimulator4 = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator4);
    PB.chooseFit(pants);
    System.setIn(sysInBackup);
    assertNotNull(PB.build(pants));

  }
}
