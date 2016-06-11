package de.malmansari.playground.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.mockito.MockitoAnnotations;

import de.malmansari.playground.model.Shipwreck;
import de.malmansari.playground.repository.ShipwreckRepository;

public class ShipwreckControllerTest {

	@InjectMocks
	private ShipwreckController shipwreckController;

	@Mock
	private ShipwreckRepository shipwreckRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetShipwreckById() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1L);
		shipwreck.setName("Test shipwreck");

		when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);
		Shipwreck returnedShipwreck = shipwreckController.get(1L);

		verify(shipwreckRepository).findOne(1L);

		assertThat(returnedShipwreck.getId(), is(1L));
	}

	@Test
	public void testShipwreckList() {
		Shipwreck shipwreck1 = new Shipwreck();
		shipwreck1.setId(1L);
		shipwreck1.setName("Test shipwreck 1");
		Shipwreck shipwreck2 = new Shipwreck();
		shipwreck2.setId(2L);
		shipwreck2.setName("Test shipwreck 2");

		List<Shipwreck> list = new ArrayList<>();
		list.add(shipwreck1);
		list.add(shipwreck2);

		when(shipwreckRepository.findAll()).thenReturn(list);
		List<Shipwreck> returnedList = shipwreckController.list();

		verify(shipwreckRepository).findAll();
		verify(shipwreckRepository, times(1)).findAll();

		assertThat(returnedList.size(), is(2));
	}

	@Test
	public void testShipwreckCreate() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1L);
		shipwreck.setName("Test shipwreck");

		when(shipwreckRepository.saveAndFlush(shipwreck)).thenReturn(shipwreck);
		Shipwreck returnedShipwreck = shipwreckController.create(shipwreck);

		verify(shipwreckRepository).saveAndFlush(shipwreck);
		verify(shipwreckRepository, times(1)).saveAndFlush(shipwreck);

		assertThat(returnedShipwreck.getName(), is("Test shipwreck"));
	}

	@Test
	public void testShipwreckUpdate() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1L);
		shipwreck.setName("Test shipwreck");

		when(shipwreckRepository.save(shipwreck)).thenReturn(shipwreck);
		Shipwreck returnedShipwreck = shipwreckController.update(1L, shipwreck);

		verify(shipwreckRepository).save(shipwreck);
		verify(shipwreckRepository, times(1)).save(shipwreck);

		assertThat(returnedShipwreck.getName(), is("Test shipwreck"));
	}

	@Test
	public void testShipwreckDelete() {
		Shipwreck shipwreck = new Shipwreck();
		shipwreck.setId(1L);
		shipwreck.setName("Test shipwreck");
		
		when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);
		shipwreckController.delete(1L);

		verify(shipwreckRepository).delete(shipwreck);
		verify(shipwreckRepository, times(1)).delete(shipwreck);

	}
}
