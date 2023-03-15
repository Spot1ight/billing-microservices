package kz.dits.vehicleservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "vehicle", ignoreUnknownFields = false)
@Getter
@Setter
public class ApplicationProperties {
    private String hello;
    private String shared;
}
