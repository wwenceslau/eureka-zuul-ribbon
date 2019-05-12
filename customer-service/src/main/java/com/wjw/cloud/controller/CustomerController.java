/**
 * 
 */
package com.wjw.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wwenceslau:wwenceslau@gmail.com
 *
 */

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Value("${server.port}")
	private String port;

	@Value("${loadIdentifier.id}")
	private String loadIdentifier;

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@GetMapping(path = "/active")
	public String active() {
		if (port.equals("0")) {
			return "Working with identifier : " + loadIdentifier;
		} else {
			return "Working in port : " + port;
		}
	}
	
	@GetMapping("/order/active")
	public String getOrderUsingRestTemplate() { 
	    ResponseEntity<String> responseEntity = new RestTemplate().getForEntity(
	            "http://localhost:8763/order-service/order/active", 
	            String.class);      
	    return responseEntity.getBody(); 
	}
}
