package com.reto1Ciclo4.demo.servicio;


import com.reto1Ciclo4.demo.model.User;
import com.reto1Ciclo4.demo.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAll(){
        return userRepository.getAll();

    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password){
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
