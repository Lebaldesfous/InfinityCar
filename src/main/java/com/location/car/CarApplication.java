package com.location.car;

import com.location.car.model.Car;
import com.location.car.model.User;
import com.location.car.repository.CarRepository;
import com.location.car.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@SpringBootApplication
public class CarApplication implements CommandLineRunner {

	final CarRepository carRepository;
	final UserRepository userRepository;

	public CarApplication(CarRepository carRepository, UserRepository userRepository) {
		this.carRepository = carRepository;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	private static final AntPathRequestMatcher[] WHITE_LIST_URLS = {
			new AntPathRequestMatcher("**"),

	};

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
				.authorizeRequests(authorizeRequests ->
						authorizeRequests
								.requestMatchers(WHITE_LIST_URLS).permitAll()

				)
				.formLogin(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable);

		return http.build();
	}

	@Override
	public void run(String... args) throws Exception {
		Car car = new Car();
		car.setName("RS3");
		car.setModel("Audi");
		car.setPrice(72000);
		car.setPictureUrl("https://i.imgur.com/7AfKzqe.jpeg");
		car.setFuel_efficiency(9);
		car.setEngine("2.5L 4 Cylinders");
		car.setHorsepower("400");
		car.setStock(2);
		carRepository.save(car);
		Car car1 = new Car();
		car1.setName("C63");
		car1.setModel("Mercedes");
		car1.setPrice(115000);
		car1.setPictureUrl("https://i.imgur.com/NmEKx6z.jpeg");
		car1.setFuel_efficiency(7);
		car1.setEngine("2.0L 4 Cylinders");
		car1.setHorsepower("476");
		car1.setStock(2);
		carRepository.save(car1);
		Car car2 = new Car();
		car2.setName("Golf 7R");
		car2.setModel("Volkswagen");
		car2.setPrice(40700);
		car2.setPictureUrl("https://i.imgur.com/BFIbvcI.jpeg");
		car2.setFuel_efficiency(9);
		car2.setEngine("2.0L TSI");
		car2.setHorsepower("320");
		car2.setStock(2);
		carRepository.save(car2);
		Car car3 = new Car();
		car3.setName("M3");
		car3.setModel("BMW");
		car3.setPrice(109950);
		car3.setPictureUrl("https://i.imgur.com/FUrb8Yx.jpeg");
		car3.setFuel_efficiency(12);
		car3.setEngine("2.5L Bi-Turbo");
		car3.setHorsepower("530");
		car3.setStock(2);
		carRepository.save(car3);

		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setEmail("admin@infinity.com");
		user.setRole("admin");
		userRepository.save(user);
	}
}
