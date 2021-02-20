package com.jeremy.calendar.controller;

import com.jeremy.calendar.model.User;
import com.jeremy.calendar.repository.UserRepository;
import com.jeremy.calendar.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/v1/api/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            user.setId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));
            userRepo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("User created");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fetchAll")
    public ResponseEntity<?> fetchAllUsers() {
        List<User> allUsers = new ArrayList<>();
        try {
            allUsers = userRepo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(allUsers);
    }
}
