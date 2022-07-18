package com.pedro.lab4sentence.controllers;

import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {
	@Autowired
	DiscoveryClient discoverClient;
	
	@GetMapping("/sentence")
	public String getSentence() {
		return getWord("Lab-4-SUBJECT") + " "
				+ getWord("Lab-4-VERB") + " "
				+ getWord("Lab-4-ARTICLE") + " "
				+ getWord("Lab-4-ADJECTIVE") + " "
				+ getWord("Lab-4-NOUN") + ".";
	}
	
	public String getWord(String service) {
		List<ServiceInstance> list = discoverClient.getInstances(service);
		if(list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();
			if(uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}
}
