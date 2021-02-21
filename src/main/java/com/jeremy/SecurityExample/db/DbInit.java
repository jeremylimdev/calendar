package com.jeremy.SecurityExample.db;


import com.jeremy.SecurityExample.model.User;
import com.jeremy.SecurityExample.repository.UserRepository;
import com.jeremy.SecurityExample.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DbInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!(userRepository.findByUsername("admin").isPresent() && userRepository.findByUsername("user").isPresent())) {

            User admin = new User(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME), "admin", passwordEncoder.encode("pw"), true, "ROLE_ADMIN");
            User user = new User(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME), "user", passwordEncoder.encode("pw"), true, "ROLE_USER");

            userRepository.save(admin);
            userRepository.save(user);
        }
    }
}
