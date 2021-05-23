/*
 * package net.javaguides.springbootsecurity.web;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping;
 * 
 * import net.javaguides.springbootsecurity.RegisterService; import
 * net.javaguides.springbootsecurity.entities.Register;
 * 
 * @Controller
 * 
 * @RequestMapping("/newreg") public class RegController {
 * 
 * private RegisterService reg;
 * 
 * public RegController(RegisterService reg) { super(); this.reg = reg; }
 * 
 * @ModelAttribute("user") public Register userRegister() { return new
 * Register(); }
 * 
 * @GetMapping public String showRegistrationForm() { return "newreg"; }
 * 
 * @PostMapping public String saveRegistration(@ModelAttribute("regi")Register
 * regi) { reg.save(regi); return "redirect:/newreg?success"; } }
 */