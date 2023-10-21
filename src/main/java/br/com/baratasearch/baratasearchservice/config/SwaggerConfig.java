package br.com.baratasearch.baratasearchservice.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	// Informações do serviço
	private static final String BASE_PACKAGE = "br.com.baratasearch.baratasearchservice.controller";
	private static final String SERVICE_TITULO = "BarataSearch: Aplicação para Captação Inteligente de Preços de Voos";
	private static final String SERVICE_DESCRICAO = "API REST que obtem dados de preços de viagens do Google Flights em tempo real";
	private static final String SERVICE_VERSAO = "1.0.0";
	// contato
	private static final String CONTATO_NOME = "Raike Peçanha Mendes Barata";
	private static final String CONTATO_GITHUB = "https://github.com/Raikeb";
	private static final String CONTATO_EMAIL = "Raike.mb@gmail.com";

	private ApiInfo buildApiInfo() {

		return new ApiInfoBuilder().title(SERVICE_TITULO)
				.description(SERVICE_DESCRICAO)
				.version(SERVICE_VERSAO)
				.contact(new Contact(CONTATO_NOME, CONTATO_GITHUB, CONTATO_EMAIL))
				.build();
	}

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());
	}

}
