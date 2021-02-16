package com.coach.askme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*
     * Swagger 설정 클래스입니다.
     * Swagger을 스프링 컨텍스트에서 관리할 수 있도록 @Configuration을 어노테이팅 했습니다.
     * Swagger문서를 설정하기위해 EnableSwagger2를 어노테이팅 했습니다.
     */

    /*
     * - postApi() -
     * Springfox 프레임워크의 문서 플러그인을 구현한 Docket을 빈으로 설정합니다.
     * 생성자에 문서의 타입을 넣고, BankSalad HomeAssignment API라는 이름으로 관리해줍니다.
     * 해당 문서는 모든 경로의 Http요청에 대해 문서화합니다.
     */
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("AskMe API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coach"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()));
    }

    /*
     * - apiInfo() -
     * 개발한 Api의 title, description, license, version을 담아 postsApi()에 넘깁니다.
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("AskMe")
                .description("\" 	AskMe in SSAFY!! \"")
                .version("1.0").build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "jwt", "header");
    }

    private SecurityContext securityContext() {
        return springfox
                .documentation
                .spi.service
                .contexts
                .SecurityContext
                .builder()
                .securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }
}
