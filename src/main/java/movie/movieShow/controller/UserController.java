package movie.movieShow.controller;

import movie.movieShow.model.CustomError;
import movie.movieShow.model.Movie;
import movie.movieShow.model.User;
import movie.movieShow.repo.MovieRepository;
import movie.movieShow.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;

    @PostMapping(value = "/user/register", produces = "application/json")
    private ResponseEntity<?> registerController(@RequestBody User userToRegister) {
        User isPresent = userRepository.findUserByName(userToRegister.getName());
        if(isPresent != null) {
            return ResponseEntity.ok(Set.of(new CustomError("Already exist!")));
        }

        System.out.println(userToRegister.getName());
        User newU = new User();
        newU.setName(userToRegister.getName());
        newU.setPassword(userToRegister.getPassword());
        newU.setEmail(userToRegister.getEmail());
        newU.setAdmin(false);
        newU.setBanned(false);
        userRepository.save(newU);

        return new ResponseEntity<>(newU,HttpStatus.OK);
    }
    @PostMapping(value = "/user/login", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> loginController(@RequestBody User userToRegister) {
        User isPresent = userRepository.findUserByName(userToRegister.getName());
        if(isPresent == null) {

            return ResponseEntity.ok(Set.of(new CustomError("Register first!")));
            //return new ResponseEntity<>(new CustomError("Register first!"), HttpStatus.CONFLICT);
        }

        if (isPresent.getPassword().equals(userToRegister.getPassword())  ) {
            return new ResponseEntity<>(isPresent, HttpStatus.OK);
        }
        return ResponseEntity.ok(Set.of(new CustomError("Wrong data!")));
    }

    @PostMapping(value = "/user/favorite", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> addFavorite(@RequestBody Movie movieToAdd) {
        User isPresent = userRepository.getById(movieToAdd.getUserId());
        if(isPresent == null) {
            return ResponseEntity.ok(Set.of(new CustomError("Register first!")));
        }
        Movie movie = new Movie();
        movie.setName(movieToAdd.getName());
        movie.setExternalId(movieToAdd.getExternalId());
        Movie savedMovie = movieRepository.save(movie);
        isPresent.getFavoriteMovies().add(savedMovie);
        userRepository.save(isPresent);


        return ResponseEntity.ok(isPresent.getFavoriteMovies());
    }

    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

}
