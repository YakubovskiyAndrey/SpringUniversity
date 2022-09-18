package ua.yakubovskiy.springboot.spring_rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.yakubovskiy.springboot.spring_rest.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
