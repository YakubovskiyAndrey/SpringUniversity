package ua.yakubovskiy.springboot.spring_rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.yakubovskiy.springboot.spring_rest.dao.GroupRepository;
import ua.yakubovskiy.springboot.spring_rest.entity.Group;
import java.util.List;

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

    public void delete(int id) {
        groupRepository.deleteById(id);
    }
}
