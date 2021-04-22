package com.techprimers.example.Spring._starter.resource;


import com.techprimers.example.Spring._starter.model.Users;
import com.techprimers.example.Spring._starter.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")

public class UsersResource {
    //we create to use repository
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/all")
    public List<Users> getAll() {

        return usersRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Users> getUser(@PathVariable("name") final String name) {
    return usersRepository.findByName(name);
    }
               // .orElseThrow()-> new
      //if(listOptional.isPresent()){
        //    List<Users> users1 = listOptional.get();
     // }
           @GetMapping("/id/{id}")
       public Users getId(@PathVariable("id") final Integer id){
        return usersRepository.findOne(id );
      }
      @GetMapping("/update/{name}")
    public Users update(@PathVariable("id") final Integer id, @PathVariable("name")
    final String name){
      Users users = getId(id);
        users.setName(name);

        return  usersRepository.save(users);
      }

}
