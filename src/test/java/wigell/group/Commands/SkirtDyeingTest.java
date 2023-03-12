package wigell.group.Commands;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Skirt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SkirtDyeingTest {
  @Test
  void testThatFinishIsWorking() {
    Skirt skirt = new Skirt();
    ClothCommand CC = new SkirtDyeing();

    InputStream sysInBackup = System.in;
    Random RO = new Random();
    int randomOption = RO.nextInt(2) + 1;
    String buff = String.valueOf(randomOption);
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream(buff.getBytes());
    System.setIn(optionSimulator);
    CC.finish(skirt);

    assertNotNull(skirt.getColor());

    System.setIn(sysInBackup);
  }

}