package wigell.group.Commands;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.Pants;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PantsLengthAdjustmentTest {

  @Test
  void testThatFinishIsWorking() {
    Pants pants = new Pants();
    ClothCommand CC = new PantsLengthAdjustment();

    InputStream sysInBackup = System.in;
    Random RO = new Random();
    int randomOption = RO.nextInt(3) + 1;
    String buff = String.valueOf(randomOption);
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream(buff.getBytes());
    System.setIn(optionSimulator);
    CC.finish(pants);

    assertNotNull(pants.getLength());

    System.setIn(sysInBackup);
  }
}