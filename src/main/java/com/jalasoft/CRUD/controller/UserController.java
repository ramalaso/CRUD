/**
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.CRUD.controller;

import com.jalasoft.CRUD.model.User;
import com.jalasoft.CRUD.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Implements user controller.
 *
 * @author Raul Laredo on 10/13/2019.
 * @version v1.0
 */
@RestController
@RequestMapping({"/users"})
public class UserController {

    private UserRepository repository;

    /**
     *Creates a constructor with user repository
     * @param userRepository repository for users model
     */
    UserController(UserRepository userRepository) {
        this.repository = userRepository;
    }

    /**
     * Lists all the users
     * @return list of users
     */
    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    /**
     * Gets the user by id
     * @param id for getting the user
     * @return user data
     */
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Creates new user data
     * @param user data for creating a new user
     * @return new user added to the database
     */
    @PostMapping
    public User create(@RequestBody User user){
        return repository.save(user);
    }

    /**
     * Updates data for user
     * @param id to identify the user
     * @param user data for updating
     * @return user data updated
     */
    @PutMapping(value="/{id}")
    public ResponseEntity<User> update(@PathVariable("id") long id,
                                          @RequestBody User user){
        return repository.findById(id)
                .map(record -> {
                    record.setName(user.getName());
                    record.setEmail(user.getEmail());
                    record.setPhone(user.getPhone());
                    User updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Deletes user by id
     * @param id to identify the user
     * @return null - user deleted
     */
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
