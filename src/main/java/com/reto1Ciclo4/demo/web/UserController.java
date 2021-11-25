package com.reto1Ciclo4.demo.web;


import com.reto1Ciclo4.demo.model.User;
import com.reto1Ciclo4.demo.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User u){
        return userService.save(u);

    }

}
