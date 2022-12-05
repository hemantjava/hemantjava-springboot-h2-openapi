package com.hemant.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "DocConstants.TITLE", description = "DocConstants.DESCRIPTION",
        version = "DocConstants.VERSION", termsOfService = "DocConstants.TERMSPATH",
        license = @License(name = "DocConstants.LICENCETYPE", url = "DocConstants.LICENCEPATH"),
        contact = @Contact(email = "DocConstants.EMAIL")), servers = @Server(description = "host server url"))
public class SwaggerConfig {
}

