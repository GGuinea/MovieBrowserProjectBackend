package movie.movieShow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
  @GetMapping(value = "/test", produces = "application/json")
  private ResponseEntity<String> testController() {
    return new ResponseEntity<>("Working!", HttpStatus.OK);
  }

}
