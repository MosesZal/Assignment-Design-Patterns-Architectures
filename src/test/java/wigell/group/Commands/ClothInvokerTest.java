package wigell.group.Commands;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.CEO;
import wigell.group.BusinessObjects.Skirt;
import wigell.group.BusinessObjects.TShirt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ClothInvokerTest {

  @Test
  void testCheckCommandsList() {
    ClothInvoker CI = new ClothInvoker();
    CI.checkCommandsList();
    assertFalse(CI.getCommands().isEmpty());
  }

  @Test
  void testExecuteWithSkirt() {
    ClothInvoker CI = new ClothInvoker();
    CEO ceo = new CEO();
    Skirt skirt = new Skirt();
    skirt.setName("Mia's skirt");
    InputStream sysInBackup = System.in;
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("2".getBytes());
    System.setIn(optionSimulator);
    assertTrue(CI.execute(skirt,ceo) instanceof Skirt);
    System.setIn(sysInBackup);
  }

  @Test
  void testExecuteWithTshirt() {
    ClothInvoker CI = new ClothInvoker();
    CEO ceo = new CEO();
    TShirt tShirt = new TShirt();
    tShirt.setName("Jason's t-shirt");
    InputStream sysInBackup = System.in;
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("1".getBytes());
    System.setIn(optionSimulator);
    assertTrue(CI.execute(tShirt,ceo) instanceof TShirt);
    System.setIn(sysInBackup);
  }
  // There isn't a method to test execute with pants because execute requires 2 simulated user inputs in the same method
  // when cloth is an instance of pants.
}