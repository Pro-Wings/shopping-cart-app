package com.prowings.shoppingcartapp.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.prowings.shoppingcartapp.interceptors.HeaderModificationInterceptor;
import com.prowings.shoppingcartapp.interceptors.RequestResponseLoggingInterceptor;


@Configuration
public class RestTemplateConfig {
	
	@Value("${base_url}")
	private String url;

//	@Value("${timeout}")
//	int requestTimeout;

	@Bean
    public CloseableHttpClient httpClient() {
        return HttpClients.createDefault();
    }
	
	@Bean
	public RestTemplate restTemplate() {
//		RestTemplate restTemplate = new RestTemplate(bufferingClientHttpRequestFactory());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
//		restTemplate.setErrorHandler(new MyRestTemplateResponseErrorHandler());
		
//		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
//		interceptors.add(new RequestResponseLoggingInterceptor());
//		interceptors.add(new HeaderModificationInterceptor());
		
//		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		clientHttpRequestFactory.setHttpClient(httpClient());
//		clientHttpRequestFactory.setConnectionRequestTimeout(requestTimeout);
//		clientHttpRequestFactory.setConnectTimeout(requestTimeout);
//		clientHttpRequestFactory.setReadTimeout(requestTimeout);
		return clientHttpRequestFactory;
	}

	private BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory() {

		return new BufferingClientHttpRequestFactory(clientHttpRequestFactory());

	}

}
