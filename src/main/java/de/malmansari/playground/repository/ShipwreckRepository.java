package de.malmansari.playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.malmansari.playground.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
