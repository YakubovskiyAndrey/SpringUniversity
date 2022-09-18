package ua.yakubovskiy.springboot.spring_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.yakubovskiy.springboot.spring_rest.entity.Person;
import ua.yakubovskiy.springboot.spring_rest.service.PersonService;

import javax.validation.Valid;

@Controller
public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String index(Model model) {
        model.addAttribute("people", personService.index());
        return "person/index";
    }

    @GetMapping("/person/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "person/new";
    }

    @PostMapping("/person/create")
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "person/new";
        personService.save(person);
        return "redirect:/person";
    }

    @GetMapping("/person/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.show(id));
        return "person/edit";
    }

    @PostMapping("/person/update/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {

        if (bindingResult.hasErrors()){
            return "person/edit";
        }
        personService.update(id, person);
        return "redirect:/person";
    }

    @GetMapping("/person/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable("id") int id) {
        personService.delete(id);
        return "redirect:/person";
    }

}
