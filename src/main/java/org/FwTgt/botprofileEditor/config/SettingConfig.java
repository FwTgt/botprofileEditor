package org.FwTgt.botprofileEditor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "/setting.properties")
public class SettingConfig {
    @Value("dataPath.home")
    private String dataHome;

    @Bean
    public String dataHome(){
        return dataHome;
    }
}
