package de.malmansari.playground.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HomeControllerTest {

	@Test
	public void testHome() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals("Das boot, reporting for duty!", result);
	}
}
