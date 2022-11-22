package net.tv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = DevicePackageManagerStarter.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class AuditedManagerTest extends AbstractTestCases {

  @Autowired
  private CassandraConfigurationProperties properties;

  @BeforeEach
  void setUp() {
  }

  @Test
  void addBouquetMappings() {
    //ExampleUtils.createKeyspace(properties);
    System.out.println("");
  }

}
