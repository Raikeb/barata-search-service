package br.com.baratasearch.baratasearchservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Contact;

@Configuration
public class SwaggerConfig {

	//Informações da API
	private static final String BASE_PACKAGE = "br.com.baratasearch.baratasearchservice.controller";
	private static final String API_TITULO = "BarataSearch: Uma API para Captação Inteligente de Preços de Voos";
	private static final String API_DESCRICAO = "API REST que obtem dados de passagens aéreas do Google Flights em tempo real";
	private static final String API_VERSAO = "1.0.0";
	//contato
	private static final String CONTATO_NOME = "Raike Barata";
	private static final String CONTATO_GITHUB = "https://github.com/Raikeb";
	private static final String CONTATO_LINKEDIN = "https://www.linkedin.com/in/raikeb/";
	private static final String CONTATO_EMAIL = "Raike.mb@gmail.com";

	@Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(API_TITULO)
                        .description(API_DESCRICAO)
                        .version(API_VERSAO)
                        .contact(new Contact()
                                .name(CONTATO_NOME)                                
                                .email(CONTATO_EMAIL))
                        .license(new License()
                                .name("GitHub")
                                .url(CONTATO_GITHUB)))
                .externalDocs(new ExternalDocumentation()
                        .description("Linkedin")
                        .url(CONTATO_LINKEDIN));
    }
		
}
