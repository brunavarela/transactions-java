package br.com.bruna.learningspring.controller;

import br.com.bruna.learningspring.dto.CreateDepositDto;
import br.com.bruna.learningspring.dto.UserDto;
import br.com.bruna.learningspring.model.User;
import br.com.bruna.learningspring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody final UserDto userData) {

        final User createdUser = userService.createUser(userData);

        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<User>> readUsers() {

        final List<User> allUsers = userService.readUsers();

        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable final String id) throws Exception {

        final User user = userService.retrieveUser(Long.parseLong(id));

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody final UserDto userData, @PathVariable final String id) throws Exception {

        final User updatedUser = userService.updateUser(userData, Long.parseLong(id));

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable final String id) throws Exception {

        userService.deleteUser(Long.parseLong(id));

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<User> updateUser(@RequestBody final CreateDepositDto depositData, @PathVariable final String id) throws Exception {

        final User depositedUser = userService.createDeposit(depositData, Long.parseLong(id));

        return new ResponseEntity<User>(depositedUser, HttpStatus.CREATED);
    }
}
