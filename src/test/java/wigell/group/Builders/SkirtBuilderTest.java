package wigell.group.Builders;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Customer;
import wigell.group.BusinessObjects.Pants;
import wigell.group.BusinessObjects.Skirt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class SkirtBuilderTest {

  @Test
  void testSetIDAndNameGeneratedEqualsExpectedValues() {
    Customer customer = new Customer();
    customer.setName("Moussa");
    SkirtBuilder SB = new SkirtBuilder();
    Skirt skirt = new Skirt();
    SB.setIDAndNameAutomatically(customer, skirt);
    assertEquals(1, skirt.getID());
    assertEquals("Moussa's skirt", skirt.getName());
  }

  @Test
  void testChosenSizeIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);

    SkirtBuilder SB = new SkirtBuilder();
    Skirt skirt = new Skirt();
    SB.chooseSize(skirt);
    assertNotNull(skirt.getSize());

    System.setIn(sysInBackup);
  }

  @Test
  void testChosenMaterialIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("2".getBytes());
    System.setIn(optionSimulator);

    SkirtBuilder SB = new SkirtBuilder();
    Skirt skirt = new Skirt();
    SB.chooseMaterial(skirt);
    assertNotNull(skirt.getMaterial());

    System.setIn(sysInBackup);
  }

  @Test
  void testChosenWaistLineIsNotNull() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("3".getBytes());
    System.setIn(optionSimulator);

    SkirtBuilder SB = new SkirtBuilder();
    Skirt skirt = new Skirt();
    SB.chooseWaistline(skirt);
    assertNotNull(skirt.getWaistline());

    System.setIn(sysInBackup);
  }

  @Test
  void testChoosePatternThrowsAnExceptionIfLetterIsSelected() {
    InputStream sysInBackup = System.in;

    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("a".getBytes());
    System.setIn(optionSimulator);

    SkirtBuilder SB = new SkirtBuilder();
    assertThrows(InputMismatchException.class, () -> SB.choosePattern(new Skirt()));

    System.setIn(sysInBackup);
  }

  @Test
  void TestThatBuildMethodReturnsAnObjectIfTheConditionIsMet() {
    Customer customer = new Customer();
    customer.setName("Moussa");
    SkirtBuilder SB = new SkirtBuilder();
    Skirt skirt = new Skirt();
    SB.setIDAndNameAutomatically(customer, skirt);

    InputStream sysInBackup = System.in;
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);
    SB.chooseSize(skirt);
    ByteArrayInputStream optionSimulator2 = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator2);
    SB.chooseMaterial(skirt);
    ByteArrayInputStream optionSimulator3 = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator3);
    SB.chooseWaistline(skirt);
    ByteArrayInputStream optionSimulator4 = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator4);
    SB.choosePattern(skirt);
    System.setIn(sysInBackup);
    assertNotNull(SB.build(skirt));

  }
}