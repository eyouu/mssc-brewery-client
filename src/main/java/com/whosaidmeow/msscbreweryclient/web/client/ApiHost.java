package com.whosaidmeow.msscbreweryclient.web.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@ConstructorBinding
@AllArgsConstructor
@Getter
public class ApiHost {

    private final String host;
}
