package cl.praxis.ControlReclamosTransporte.model.controller;

import cl.praxis.ControlReclamosTransporte.model.entity.Role;
import cl.praxis.ControlReclamosTransporte.model.entity.User;
import cl.praxis.ControlReclamosTransporte.model.service.IRole;
import cl.praxis.ControlReclamosTransporte.model.service.IUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final IUser service;
    private final IRole roleServive;
    public UserController(IUser service, IRole roleServive) {
        this.service = service;
        this.roleServive = roleServive;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("users", service.findAll());
        return "userList";
        }
        @GetMapping("/new")
    public String create(Model model){

    model.addAttribute("roles", roleServive.findAll());
        return "newUser";
        }

    @PostMapping
    public String update(@ModelAttribute User user){
        boolean result = service.update(user);
        return "redirect:/users";
    }


    @PostMapping("/new")
    public String create(@ModelAttribute User user){
        boolean result = service.create(user);

        return "redirect:/users";
    }
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        return "redirect:/users";
    }

}
