package com.reto1Ciclo4.demo.repositorio;

import com.reto1Ciclo4.demo.model.User;
import com.reto1Ciclo4.demo.repositorio.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id){

        return userCrudRepository.findById(id);
    }

    public  Optional<User> autenticarUsuario(String email, String password){

        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User save(User u){

        return userCrudRepository.save(u);
    }

    public boolean existeEmail (String email){
        Optional<User> usuario =  userCrudRepository.findByEmail(email);
        return usuario.isPresent();
    }
}
