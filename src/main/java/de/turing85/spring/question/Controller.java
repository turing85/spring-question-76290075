package de.turing85.spring.question;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(Controller.ROOT_URL)
public class Controller {

  public static final String ROOT_URL = "/foo/bar";

  @GetMapping
  String fooBar() {
    return "foobar";
  }

  @GetMapping("**")
  ResponseEntity<Void> fooBarForward() {
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(URI.create(ROOT_URL));
    return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
  }

}
