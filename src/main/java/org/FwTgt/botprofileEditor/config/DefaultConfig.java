package org.FwTgt.botprofileEditor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class DefaultConfig {
    @Bean
    public byte[] defaultINF() throws IOException {
        ClassPathResource resource = new ClassPathResource("/default/defaultINF.db");
        InputStream inputStream =resource.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return bytes;
    }
}
