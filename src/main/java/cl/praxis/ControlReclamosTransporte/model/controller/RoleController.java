package cl.praxis.ControlReclamosTransporte.model.controller;

import cl.praxis.ControlReclamosTransporte.model.entity.Role;
import cl.praxis.ControlReclamosTransporte.model.service.IRole;
import cl.praxis.ControlReclamosTransporte.model.service.IUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final IRole service;
    private final IUser userService;

    public RoleController(IRole service, IUser userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("roles", service.findAll());
        return "roleList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("roles", service.findOne(id));
        model.addAttribute("users", userService.findAll());
        return "roleEdit";
    }

    @PostMapping
    public String update(@ModelAttribute Role role){
        boolean result = service.update(role);
        return "redirect:/roles";
    }

    @GetMapping("/new")
    public String toCreate(){

        return "newRole";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Role role){
        boolean result = service.create(role);

        return "redirect:/roles";
    }
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);

        return "redirect:/roles";
    }

}
