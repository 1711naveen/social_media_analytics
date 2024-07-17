package com.naveen.smad.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://127.0.0.1:5173")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return ResponseEntity.ok(user.get());
        throw new RuntimeException("User not found");
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
