package net.javaguides.springbootsecurity.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.springbootsecurity.entities.Role;
import net.javaguides.springbootsecurity.entities.User;
import net.javaguides.springbootsecurity.repositories.RoleRepo;
import net.javaguides.springbootsecurity.repositories.UserRepository;

@Controller
public class LoginController {
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	@Autowired
	UserRepository userRepo;
	@Autowired
	RoleRepo roleRepo;
	@Autowired
	private UserRepository usr;
	
	@GetMapping("/registers")
	public String getRegisters()
	{
		return "register1";
	}
	
	@PostMapping("/registers")
	public String saveUsr(@ModelAttribute("user") User user)
	{
		if(checkIfUserExist(user.getEmail()))
		{
			return "redirect:/registers?fail";
		}
		else
		{
		String password = user.getPassword();
		user.setPassword(bcrypt.encode(password));
		List<Role> roles = new ArrayList<>(); 
		roles.add(roleRepo.findById(3).get());
		user.setRoles(roles);
		userRepo.save(user);
		return "redirect:/shop";
		}
	}
	public boolean checkIfUserExist(String email) 
	{
	        return usr.findUserByEmail(email)== null ? true : false;
	}
	
}
