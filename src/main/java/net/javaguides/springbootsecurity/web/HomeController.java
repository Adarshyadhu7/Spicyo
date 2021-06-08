package net.javaguides.springbootsecurity.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import net.javaguides.springbootsecurity.entities.Register;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.javaguides.springbootsecurity.RegisterService;
import net.javaguides.springbootsecurity.entities.Message;
import net.javaguides.springbootsecurity.repositories.MessageRepository;

@Controller
public class HomeController
{
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private RegisterService reg;

	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("msgs", messageRepository.findAll());		
		return "userhome";
	}
	@GetMapping("/usr")
	public String usrhome()
	{	
		return "front";
	}
	
	@PostMapping("/messages")
	public String saveMessage(Message message)
	{
		messageRepository.save(message);
		return "redirect:/home";
	}
	
	@RequestMapping("/register")
	public String ViewRegistration(Model m)
	{
		List<Register> reglist = reg.listAll();
		m.addAttribute("reglist", reglist);
		return "register";
	}
	
	  @RequestMapping("/newreg") public String addNewUser(Model m)
	  { 
		  Register regi=new Register(); 
		  m.addAttribute("regi", regi); 
		  return "newreg"; 
	  }
	  
	  @RequestMapping(value="/save", method=RequestMethod.POST) 
	  public String saveRegistration(@ModelAttribute("regi")Register regi) 
	  { 
		  reg.save(regi);
		  return "redirect:/newreg?success";
	  } 
}