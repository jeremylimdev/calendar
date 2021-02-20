package com.jeremy.calendar.db;

import com.jeremy.calendar.model.User;
import com.jeremy.calendar.repository.UserRepository;
import com.jeremy.calendar.service.SequenceGeneratorService;
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

    public DbInit (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = new User(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME), "admin", passwordEncoder.encode("pw"), true, "ADMIN", "");
        User user = new User(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME),"user", passwordEncoder.encode("pw"), true, "USER", "");

        userRepository.save(admin);
        userRepository.save(user);
    }
}
