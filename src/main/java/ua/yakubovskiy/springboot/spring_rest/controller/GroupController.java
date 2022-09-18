package ua.yakubovskiy.springboot.spring_rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.yakubovskiy.springboot.spring_rest.entity.Group;
import ua.yakubovskiy.springboot.spring_rest.service.GroupService;

import javax.validation.Valid;

@Controller
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public String index(Model model) {
        model.addAttribute("group", groupService.index());
        return "group/index";
    }

    @GetMapping("/group/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String newGroup(@ModelAttribute("group") Group group) {
        return "group/new";
    }

    @PostMapping("/group/create")
    public String create(@ModelAttribute("group") @Valid Group group) {
        groupService.save(group);
        return "redirect:/group";
    }

}
