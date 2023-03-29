package kz.dits.passageservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@ConfigurationProperties(prefix = "passage", ignoreUnknownFields = false)
@Getter
@Setter
@RefreshScope
public class ApplicationProperties {
    private String hello;
    private String shared;

}
