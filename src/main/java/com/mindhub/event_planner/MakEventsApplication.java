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

			Location location1 = new Location("Park", "CLL 78", 300, "https://grupolar.com.mx/wp-content/uploads/2023/07/parques-cerca-de-mi.jpg");
			locationRepository.save(location1);

			Location location2 = new Location("Hotel", "Street 15#4", 400, "https://cdn.traveltripper.io/site-assets/192_552_3091/media/2017-05-12-072727/STEW-Exterior-Night-Web.jpg");
			locationRepository.save(location2);

			Event event1 = new Event("An exciting kids' event in the park for children aged 7 and up. Games, laughter, activities, and new adventures, ensuring an unforgettable day filled with joy and memorable moments.", "https://fibramorales.co/cdn/shop/files/fabrica-de-parques_infantiles.jpg?v=1695673754&width=3840", (short) 7, "Park Adventure Day");
			manager.addEvents(event1);
			eventRepository.save(event1);

			Event event2 = new Event("A sumptuous buffet in a New York hotel, offering an array of international cuisines, fresh seafood, delectable desserts, and elegant dining ambiance. A culinary journey you won’t forget.", "https://descubrenyc.us/wp-content/uploads/2024/07/saile-ilyas-SiwrpBnxDww-unsplash.jpg", (short) 16, "New York Feast");
			manager2.addEvents(event2);
			eventRepository.save(event2);

			Event event3 = new Event("An exciting kids' event in the park for children aged 7 and up. Games, laughter, activities, and new adventures, ensuring an unforgettable day filled with joy and memorable moments.", "https://fibramorales.co/cdn/shop/files/fabrica-de-parques_infantiles.jpg?v=1695673754&width=3840", (short) 7, "Park Adventure Day");
			manager2.addEvents(event3);
			eventRepository.save(event3);

			Event event4 = new Event("A sumptuous buffet in a New York hotel, offering an array of international cuisines, fresh seafood, delectable desserts, and elegant dining ambiance. A culinary journey you won’t forget.", "https://descubrenyc.us/wp-content/uploads/2024/07/saile-ilyas-SiwrpBnxDww-unsplash.jpg", (short) 16, "New York Feast");
			manager.addEvents(event4);
			eventRepository.save(event4);

			EventLocation eventLocation1 = new EventLocation(LocalDateTime.now().plusDays(7), 200, event1, location1);
			eventLocationRepository.save(eventLocation1);

			EventLocation eventLocation2 = new EventLocation(LocalDateTime.now().plusDays(14), 150, event2, location2);
			eventLocationRepository.save(eventLocation2);

			EventLocation eventLocation3 = new EventLocation(LocalDateTime.now().plusDays(7), 200, event3, location1);
			eventLocationRepository.save(eventLocation3);

			EventLocation eventLocation4 = new EventLocation(LocalDateTime.now().plusDays(14), 150, event4, location2);
			eventLocationRepository.save(eventLocation4);

			CustomerEvent customerEvent1 = new CustomerEvent(user, eventLocation1);
			customerEventRepository.save(customerEvent1);

			CustomerEvent customerEvent2 = new CustomerEvent(user1, eventLocation1);
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
