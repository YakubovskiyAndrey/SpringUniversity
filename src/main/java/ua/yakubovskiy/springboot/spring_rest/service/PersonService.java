package ua.yakubovskiy.springboot.spring_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yakubovskiy.springboot.spring_rest.dao.PersonRepository;
import ua.yakubovskiy.springboot.spring_rest.entity.Person;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> index(){
        return personRepository.findAll();
    }

    public Person show(int id){
        Optional<Person> optional = personRepository.findById(id);
        return optional.get();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void update(int id, Person person) {
        Person personUpdated = show(id);
        personUpdated.setAge(person.getAge());
        personUpdated.setEmail(person.getEmail());
        personUpdated.setName(person.getName());
        save(personUpdated);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }

}
