package net.tv;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration
public class ContainerBeanConfiguration {

  @Bean(initMethod = "start", destroyMethod = "stop")
  @ConfigurationProperties("test.containers")
  CassandraContainer<?> cassandraDockerContainer() {
    return new CassandraContainer<>(
        DockerImageName.parse("datastax/dse-server:6.7.8").asCompatibleSubstituteFor("cassandra"))
        .withEnv("DS_LICENSE", "accept").withInitScript("init.cql");
  }

}
