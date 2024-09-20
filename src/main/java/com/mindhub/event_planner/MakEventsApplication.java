package com.mindhub.event_planner;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.enums.LikeEnum;
import com.mindhub.event_planner.models.*;
import com.mindhub.event_planner.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MakEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakEventsApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, ManagerRepository managerRepository, AdminRepository adminRepository, CommentRepository commentRepository, CustomerEventRepository customerEventRepository, EventLocationRepository eventLocationRepository, EventRepository eventRepository, LikeRepository likeSRepository, LocationRepository locationRepository){
		return args -> {

			Admin admin = new Admin("Luisa","Mendoza", "luisa@gmail.com","12345", true);
			adminRepository.save(admin);

			Manager manager = new Manager("Fernanda", true, "Valencia", "fernanda@gmail.com", "6789", (short) 21, Gender.FEMALE);
			managerRepository.save(manager);

			UserEntity user = new UserEntity("Melba", true, "Morel", "melba@gmail.com", "morel123", (short) 36, Gender.FEMALE);
			userRepository.save(user);

			Location location1 = new Location("Park", "CLL 78", 500, "URL");
			locationRepository.save(location1);

			Event event1 = new Event("A funny event", "URL", (short) 7, "Funny event");
			manager.addEvents(event1);
			eventRepository.save(event1);

			EventLocation eventLocation1 = new EventLocation(LocalDateTime.now().plusDays(14), 450);
			location1.addEventLocations(eventLocation1);
			event1.addEventLocations(eventLocation1);
			eventLocationRepository.save(eventLocation1);

			CustomerEvent customerEvent1 = new CustomerEvent();
			user.addCustomerEvents(customerEvent1);
			eventLocation1.addCustomerEvents(customerEvent1);
			customerEventRepository.save(customerEvent1);

			Comment comment1 = new Comment("I loved this event :D");
			user.addComments(comment1);
			event1.addComments(comment1);
			commentRepository.save(comment1);

			LikeStatus likeS1 = new LikeStatus(LikeEnum.LIKE);
			user.addLikeS(likeS1);
			event1.addLikeS(likeS1);
			likeSRepository.save(likeS1);
		};
	}

}
