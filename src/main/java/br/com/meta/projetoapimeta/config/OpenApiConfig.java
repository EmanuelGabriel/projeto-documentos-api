package br.com.meta.projetoapimeta.config;

import org.springdoc.webmvc.ui.SwaggerConfig;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
		info = @Info(description = "API aberta para criação de QR-CODE", 
		termsOfService = "Termos de serviço",
title = "Gerador QR-CODE - API", 
version = "1.0.0", 
contact = @Contact(name = "Emanuel Gabriel Sousa", email = "emanuel.gabriel.sousa@protonmail.com", url = "emanuelgabriel.github.io")))
public class OpenApiConfig extends SwaggerConfig{

}
