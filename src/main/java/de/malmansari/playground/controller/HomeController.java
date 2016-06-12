package de.malmansari.playground.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HomeController {

	@RequestMapping("/")
	public String home() {
		log.debug("Initial commit from yahya");
		return "Das boot, reporting for duty!";
	}
}
