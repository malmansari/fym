package de.malmansari.playground.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.malmansari.playground.TestApplication;
import de.malmansari.playground.model.Shipwreck;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@Slf4j
public class ShipwreckRepositoryIntegrationTest {

	@Autowired
	private ShipwreckRepository shipwreckRepository;
	
	@Test
	public void testSaveAndFlush() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setName("Test saveAndFlush");
		log.info("shipwreck Before saveAndFlush: {}", shipwreck);
		
		Shipwreck savedShipwreck = shipwreckRepository.saveAndFlush(shipwreck);
		log.info("shipwreck Before saveAndFlush: {}", shipwreck);
		log.info("savedShipwreck Before saveAndFlush: {}", savedShipwreck);

		assertThat(savedShipwreck.getId(), is(greaterThan(0L)));
		assertThat(savedShipwreck.getName(), is(equalTo("Test saveAndFlush")));
	}

	@Test
	public void testFindAll() {
		List<Shipwreck> list = shipwreckRepository.findAll();
		assertThat(list.size(), is(greaterThanOrEqualTo(0)));
	}
}
