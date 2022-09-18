package ua.yakubovskiy.springboot.spring_rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.yakubovskiy.springboot.spring_rest.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
