package com.hoangdp.heodat.dev.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@PropertySource(value = "classpath:loda.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "loda")
public class AppProperties {
    private String email;
    private String googleAnalyticsId;

    private List<String> authors;

    private Map<String, String> exampleMap;
}
