package JPA_Rent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceLocation {

    PersonRepository personRepository;
    RentRepository rentRepository;
    VehiculeRepository vehiculeRepository;

    @Autowired
    public ServiceLocation(PersonRepository personRepository, VehiculeRepository vehiculeRepository, RentRepository rentRepository){
        this.personRepository = personRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.rentRepository = rentRepository;
    }

    @GetMapping(value = "/persons")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Person> listOfPersons(){
        return personRepository.findAll();
    }

    @GetMapping(value = "/vehicules")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Vehicule> listOfVehicules(){
        return vehiculeRepository.findAll();
    }

    @GetMapping(value = "/rents")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Rent> listOfRents(){
        return rentRepository.findAll();
    }
}
