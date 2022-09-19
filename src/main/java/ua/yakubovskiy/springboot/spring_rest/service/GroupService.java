package ua.yakubovskiy.springboot.spring_rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yakubovskiy.springboot.spring_rest.dao.GroupRepository;
import ua.yakubovskiy.springboot.spring_rest.entity.Group;
import ua.yakubovskiy.springboot.spring_rest.entity.Person;
import ua.yakubovskiy.springboot.spring_rest.exception.NoSuchException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public List<Group> index(){
        return groupRepository.findAll();
    }

    public void save(Group group) {
        groupRepository.save(group);
    }

    public Group show(int id){
        Optional<Group> optional = groupRepository.findById(id);
        return optional.get();
    }

    public void addPersonToGroup(int id, Person person) {
        Group group = show(id);
        if(group == null){
            throw new NoSuchException("Group not found");
        }
        if(group.getPersonList() == null){
            group.setPersonList(new ArrayList<>());
        }
        group.getPersonList().add(person);
        person.setGroup(group);
        save(group);
    }

    public void delete(int id) {
        groupRepository.deleteById(id);
    }
}
