package net.tv;

import static org.springframework.util.SocketUtils.findAvailableTcpPort;

import org.junit.jupiter.api.BeforeAll;

public class AbstractTestCases {

  @BeforeAll
  static void beforeAll() {
    System.setProperty("server.port", String.valueOf(findAvailableTcpPort()));
  }

}
