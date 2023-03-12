package wigell.group.Commands;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Cloth;
import wigell.group.BusinessObjects.TShirt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TShirtDyingTest {

  @Test
  void testThatFinishIsSettingTheRightColorToTheShirt() {
    TShirt tShirt = new TShirt();
    TShirtDying tShirtDyingCommand = new TShirtDying();

    InputStream sysInBackup = System.in;
    Random RO = new Random();
    int randomOption = RO.nextInt(2) + 1;
    String buff = String.valueOf(randomOption);
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream(buff.getBytes());
    System.setIn(optionSimulator);
    tShirtDyingCommand.finish(tShirt);

    assertEquals(tShirt.getColor(), tShirtDyingCommand.getColors()[randomOption - 1]);

    System.setIn(sysInBackup);
  }
}