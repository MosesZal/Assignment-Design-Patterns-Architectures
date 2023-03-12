package wigell.group.FrontEnd;

import org.junit.jupiter.api.Test;
import wigell.group.BusinessObjects.CEO;
import wigell.group.BusinessObjects.Customer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OnlineStoreMenuTest {

  @Test
  void testWhetherStartScreenPrintsItsContent() {
    OnlineStoreMenu OSMmock = mock(OnlineStoreMenu.class);
    doNothing().when(OSMmock).startScreen();
    OSMmock.startScreen();
    verify(OSMmock, times(1)).startScreen();
  }

  @Test
  void testThatTheUserIsSetToNullWhenOption4IsSelectedInTheOrderingMethod() {
    OnlineStoreMenu OSM = new OnlineStoreMenu();
    Customer customer = new Customer("Moses Zal", "Sweden", "moses.zal@gmail.com", "1234", OSM);
    CEO ceo = new CEO();
    OSM.setUser(customer);
    InputStream sysInBackup = System.in;
    ByteArrayInputStream optionSimulator = new ByteArrayInputStream("4".getBytes());
    System.setIn(optionSimulator);
    OSM.ordering(ceo);
    System.setIn(sysInBackup);
    assertNull(OSM.getUser());
  }

}