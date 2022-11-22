package net.tv;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class CassandraConfigurationProperties {

  private String host;
  private int port;
  private String keyspace;
  private String datacenter;
}
