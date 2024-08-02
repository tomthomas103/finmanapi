package com.thoma.finmanapi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Finance Manager App APIs",
        version = "0.0.1",
        description = "API Details",
        contact = @Contact(name = "Tom Thomas", email = "tomthomas@live.in"),
        license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html")
))
public class OpenAPIConfig {
    // Additional configuration if needed
}
