package net.tv;

import net.tv.CassandraConfigurationProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.CassandraContainer;

@Configuration
public class TestBeanConfiguration {

  @Bean
  CassandraConfigurationProperties cassandraConfigurationProperties(CassandraContainer<?> container,
      @Value("${application.cassandra.keyspace}") String keyspace,
      @Value("${application.cassandra.datacenter}") String datacenter) {
    return new CassandraConfigurationProperties()
        .setHost(container.getHost())
        .setPort(container.getMappedPort(9042))
        .setKeyspace(keyspace)
        .setDatacenter(datacenter);
  }

}
