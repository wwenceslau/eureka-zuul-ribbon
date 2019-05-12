package com.wjw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.wjw.cloud.config.SimpleFilter;

/**
 * <h1>
 * A Spring Cloud criou um proxy Zuul incorporado para facilitar o desenvolvimento de um caso de uso
 * comum em que um aplicativo de UI deseja fazer chamadas de proxy para um ou mais serviços de backend.
 * Esse recurso é útil para uma interface de usuário fazer proxy para os serviços de backend, evitando 
 * a necessidade de gerenciar as preocupações de CORS e autenticação de forma independente para todos 
 * os backends.
 * </h1>
 * 
 * @author wwenceslau:wwenceslau@gmail.com
 * 
 * @since 29/04/2019
 * @version 00.01
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@RefreshScope
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
	
}
