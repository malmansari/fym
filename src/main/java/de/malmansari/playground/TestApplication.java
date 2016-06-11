package de.malmansari.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TestApplication.class, args);
		
		String x = "imode";
		if(x.equals(MobileUserIdType.IMODE.toString())) {
			System.out.println(x);
		} else {
			System.out.println("hehe");

		}
	}
}
