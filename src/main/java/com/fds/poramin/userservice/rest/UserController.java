package com.fds.poramin.userservice.rest;

import com.fds.poramin.userservice.model.User;
import com.fds.poramin.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public User loadById(@PathVariable Long userId) {
        return this.userService.findById(userId);
    }

    @GetMapping("/user/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> loadAll() {
        return this.userService.findAll();
    }

    /*
     *  We are not using userService.findByUsername here(we could),
     *  so it is good that we are making sure that the user has role "ROLE_USER"
     *  to access this endpoint.
     */
    @GetMapping("/whoami")
    @PreAuthorize("hasRole('USER')")
    public User user(Principal user) {
        return this.userService.findByUsername(user.getName());
    }

}
