package com.proxyserver.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/headers")
public class ProxyServerController {

	@GetMapping
	public ResponseEntity<List<String>> multiValue(@RequestHeader MultiValueMap<String, String> headers) {
		List<String> response = new ArrayList<>();
		headers.forEach((key, value) -> {
			response.add(String.format("Header '%s' = %s", key, value.stream().collect(Collectors.joining("|"))));
		});
		return new ResponseEntity<List<String>>(response, HttpStatus.OK);
	}

}
