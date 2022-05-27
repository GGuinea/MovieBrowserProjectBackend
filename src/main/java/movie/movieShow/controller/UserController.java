package movie.movieShow.controller;

import movie.movieShow.model.User;
import movie.movieShow.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/user/login", produces = "application/json")
    private ResponseEntity<?> registerController(@RequestBody User userToLog) {
        System.out.println(userToLog.getName());
        User newU = new User();
        newU.setName(userToLog.getName());
        newU.setPassword(userToLog.getPassword());
        newU.setEmail("email");
        userRepository.save(newU);

        return new ResponseEntity<>(userRepository.findAll(),HttpStatus.OK);
    }
}
