package jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwt.entity.User;
import jwt.service.UserService;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		String text = "this is a private page";
		text+= "this page is not allowed to unauthenticated users";
		return text;
	}
	
	@RequestMapping("/success")
	public String forAll() {
		String text = "Hello User. You have logged in sucessfully";
		return text;
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return this.userService.createUser(user);
	}
	
	@GetMapping("/allusers")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<?> admin() {
		try {
			return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("You are not authorized", HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> user() {
		try {
			return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("You are not authorized", HttpStatus.OK);
		}
	}
}
