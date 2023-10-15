package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BuddyInfoRepo buddyrepo, AddressBookRepo bookrepo) {
		return (args) -> {

			// save some buddies

			BuddyInfo HR = (new BuddyInfo("HR", "942 Rotary Way", "613 513 5160"));
			BuddyInfo HJ= (new BuddyInfo("HJ", "2759 Carousel Cr", "613 413 6524"));
			BuddyInfo Khaled = (new BuddyInfo("Khaled", "162 Berrigan Dr", "613 600 8653"));
			BuddyInfo Mo = (new BuddyInfo("Mo", "946 Rotary Way", "343 262 2698"));

			buddyrepo.save(HR);
			buddyrepo.save(HJ);
			buddyrepo.save(Khaled);
			buddyrepo.save(Mo);

			// creating addressbook object and adding buddies to it

			AddressBook addressBook = new AddressBook();

			addressBook.addBuddy(HR);
			addressBook.addBuddy(HJ);
			addressBook.addBuddy(Khaled);
			addressBook.addBuddy(Mo);

			bookrepo.save(addressBook);



			//fetch address book by findAll
			log.info("");
			log.info("Address book found with findAll(): ");
			log.info("------------------------------");
			for (AddressBook addressBook1 : bookrepo.findAll()) {
				log.info(addressBook1.toString());
			}
			log.info("");


            //fetch buddies
			log.info("Buddies found with findAll(): ");
			log.info("------------------------------");
			for (BuddyInfo buddyInfo : buddyrepo.findAll()) {
				log.info(buddyInfo.toString());
			}
			log.info("");

			//fetch a buddy by ID
			BuddyInfo buddyInfo = buddyrepo.findById(1L);
			log.info("Buddy found with findByID(1L): ");
			log.info("-------------------------------");
			log.info(buddyInfo.toString());
			log.info("");

			//fetch buddy by name
			log.info("Buddy found by findByName('Jim'): ");
			log.info("---------------------------------");
			buddyrepo.findByName("Jim").forEach(Jim -> {
				log.info(Jim.getName());
			});
			log.info("");

			//fetch buddy by address
			log.info("Buddy found by findByAddress('942 Rotary Way'): ");
			log.info("---------------------------------");
			buddyrepo.findByAddress("942 Rotary Way").forEach(hr -> {
				log.info(hr.getAddress());
			});
			log.info("");

			//fetch buddy by number
			log.info("Buddy found by findByPhoneNumber('613 600 8653'): ");
			log.info("---------------------------------");
			buddyrepo.findByNumber("613 600 8653").forEach(kiwi -> {
				log.info(kiwi.getPhoneNumber());
			});

			log.info("");

		};
	}
}

