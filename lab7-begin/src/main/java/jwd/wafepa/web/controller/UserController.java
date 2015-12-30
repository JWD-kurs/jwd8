package jwd.wafepa.web.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import jwd.wafepa.model.User;
import jwd.wafepa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	private void init() {
		User user1 = new User();
		user1.setEmail("user1@wafepa.com");
		user1.setPassword("12345");
		user1.setFirstname("User");
		user1.setLastname("One");
		
		User user2 = new User();
		user2.setEmail("user2@wafepa.com");
		user2.setPassword("12345");
		user2.setFirstname("User");
		user2.setLastname("Two");
		
		userService.save(user1);
		userService.save(user2);
	}

	@RequestMapping(method=RequestMethod.GET)
	public String getUser(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("usersModel", users);
		return "users";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String remove(@PathVariable Long id) {
		userService.remove(id);
		return "redirect:/users";
	}
	

}
