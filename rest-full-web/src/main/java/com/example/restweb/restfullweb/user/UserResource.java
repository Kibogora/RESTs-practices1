package com.example.restweb.restfullweb.user;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private UserDaoService  service;
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieve(@PathVariable int id ){
        User user = service.findOne(id);

        if(user==null)
            throw  new UserNotFoundException("id:"+id);

        return user;

    }
    //DELETE/users
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id ) {
        service.deleteById(id);
    }
    //POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        // /users/4 => /users , user.getID
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(savedUser.getId())
                 .toUri(); //users/4/ => /{id}, user.getID
        return ResponseEntity.created(location).build();
    }
}
