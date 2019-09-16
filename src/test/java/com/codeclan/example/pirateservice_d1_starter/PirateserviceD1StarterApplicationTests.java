package com.codeclan.example.pirateservice_d1_starter;

import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Raid;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import com.codeclan.example.pirateservice_d1_starter.repositories.PirateRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.RaidRepository;
import com.codeclan.example.pirateservice_d1_starter.repositories.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceD1StarterApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createPirateAndShipAndRaid(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate);

		Raid raid = new Raid("Big Raid", 100);
		raidRepository.save(raid);
	}

//	@Test
//	public void canAddRaidToPirate(){
//		Ship ship = new Ship("The Big Flying Dutchman");
//		Raid raid = new Raid("Big Raid", 100);
//		Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
//		shipRepository.save(ship);
//		raidRepository.save(raid);
//		pirateRepository.save(pirate);
//		pirate.addRaid(raid);
//	}

	@Test
	public void canAddPirateToRaid(){
		Ship ship = new Ship("The Other Flying Dutchman");
		Pirate pirate = new Pirate("Jack0", "McSparrow", 32, ship);
		Raid raid = new Raid("Bigger Raid", 1000);
		shipRepository.save(ship);
		raidRepository.save(raid);
		pirateRepository.save(pirate);
		raid.addPirate(pirate);
		raidRepository.save(raid);
	}

}
