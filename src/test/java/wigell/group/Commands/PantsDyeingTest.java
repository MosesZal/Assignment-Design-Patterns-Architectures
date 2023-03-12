package wigell.group.Commands;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Pants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PantsDyeingTest {

  @Test
  void testThatFinishIsWorking() {
    Pants pants = new Pants();
    ClothCommand CC = new PantsDyeing();

    InputStream sysInBackup = System.in;
    Random RO = new Random();
    int randomOption = RO.nextInt(2) + 1;
    String buff = String.valueOf(randomOption);
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream(buff.getBytes());
    System.setIn(optionSimulator);
    CC.finish(pants);

    assertNotNull(pants.getColor());

    System.setIn(sysInBackup);
  }
}