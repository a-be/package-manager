package net.tv;

import com.datastax.oss.driver.api.core.CqlSession;
import java.net.InetSocketAddress;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CassandraBeanConfiguration {

  @Bean
  @ConfigurationProperties("application.cassandra")
  @ConditionalOnProperty("application.cassandra.host")
  CassandraConfigurationProperties cassandraConfigurationProperties() {
    return new CassandraConfigurationProperties();
  }

  @Bean
  CqlSession cqlSession(CassandraConfigurationProperties properties) {
    return CqlSession.builder()
        .addContactPoint(new InetSocketAddress(properties.getHost(), properties.getPort()))
        .withLocalDatacenter(properties.getDatacenter())
        .build();
  }

}
