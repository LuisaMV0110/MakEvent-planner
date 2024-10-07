package com.mindhub.event_planner;

import com.mindhub.event_planner.enums.Gender;
import com.mindhub.event_planner.enums.LikeEnum;
import com.mindhub.event_planner.models.*;
import com.mindhub.event_planner.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class MakEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakEventsApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, ManagerRepository managerRepository, AdminRepository adminRepository, CommentRepository commentRepository, CustomerEventRepository customerEventRepository, EventLocationRepository eventLocationRepository, EventRepository eventRepository, LikeRepository likeSRepository, LocationRepository locationRepository){
		return args -> {

			Admin admin = new Admin("Luisa","Mendoza", "luisa@gmail.com", passwordEncoder.encode("12345"), true);
			adminRepository.save(admin);

			Manager manager = new Manager("Fernanda", true, "Valencia", "fernanda@gmail.com", passwordEncoder.encode("6789"), (short) 21, Gender.FEMALE);
			managerRepository.save(manager);

			Manager manager2 = new Manager("Mario", true, "Quintero", "mario@gmail.com", passwordEncoder.encode("6789"), (short) 31, Gender.MALE);
			managerRepository.save(manager2);

			UserEntity user = new UserEntity("Melba", true, "Morel", "melba@gmail.com", passwordEncoder.encode("morel123"), (short) 36, Gender.FEMALE);
			userRepository.save(user);

			UserEntity user1 = new UserEntity("Marta", true, "Morel", "marta@gmail.com", passwordEncoder.encode("marta123"), (short) 41, Gender.FEMALE);
			userRepository.save(user1);

			Location location1 = new Location("Park", "CLL 78", 500, "URL");
			locationRepository.save(location1);

			Event event1 = new Event("A funny event", "URL", (short) 7, "Funny event");
			manager.addEvents(event1);
			eventRepository.save(event1);

			Event event2 = new Event("Buffet in NY", "URL", (short) 16, "Delicious food");
			manager2.addEvents(event2);
			eventRepository.save(event2);

			EventLocation eventLocation1 = new EventLocation(LocalDateTime.now().minusDays(14), 450);
			location1.addEventLocations(eventLocation1);
			event1.addEventLocations(eventLocation1);
			eventLocationRepository.save(eventLocation1);

			CustomerEvent customerEvent1 = new CustomerEvent();
			user.addCustomerEvents(customerEvent1);
			eventLocation1.addCustomerEvents(customerEvent1);
			customerEventRepository.save(customerEvent1);

			CustomerEvent customerEvent2 = new CustomerEvent();
			user1.addCustomerEvents(customerEvent2);
			eventLocation1.addCustomerEvents(customerEvent2);
			customerEventRepository.save(customerEvent2);

			Comment comment1 = new Comment("I loved this event :D");
			user.addComments(comment1);
			event1.addComments(comment1);
			commentRepository.save(comment1);

			Comment comment2 = new Comment("I like the food on this buffet");
			user1.addComments(comment2);
			event2.addComments(comment2);
			commentRepository.save(comment2);

			LikeStatus likeS1 = new LikeStatus(LikeEnum.LIKE);
			user.addLikeS(likeS1);
			event1.addLikeS(likeS1);
			likeSRepository.save(likeS1);

			LikeStatus likeS2 = new LikeStatus(LikeEnum.LIKE);
			user1.addLikeS(likeS2);
			event2.addLikeS(likeS2);
			likeSRepository.save(likeS2);
		};
	}

}
