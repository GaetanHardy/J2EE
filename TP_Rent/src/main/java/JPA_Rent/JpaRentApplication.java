package JPA_Rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaRentApplication<args> {

	@Autowired
	RentRepository rentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaRentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {

			Person tintin = new Person();
			tintin.setName("Tintin");

			Car c1 = new Car();
			c1.setPlatenumber("22BB33");
			c1.setNumberOfSeats(4);

			Rent rent = new Rent();
			rent.setPerson(tintin);
			tintin.getRents().add(rent);
			rent.setVehicule(c1);
			c1.getRents().add(rent);
			rent.setDateDebut("01-01-2020");
			rent.setDateFin("31-12-2020");
			rentRepository.save(rent);
		};
	}
}
