package net.javaguides.springbootsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.springbootsecurity.GlobalData;
import net.javaguides.springbootsecurity.ProductService;
import net.javaguides.springbootsecurity.entities.Product;

@Controller
public class CartController {
	@Autowired
	ProductService products;
	
	@GetMapping("/addToCart/{id}")
	public String addtoCart(@PathVariable Long id)
	{
		GlobalData.cart.add(products.getProductById(id).get());
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
	public String cartGet(Model m)
	{
		m.addAttribute("cartcount",GlobalData.cart.size());
		m.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		m.addAttribute("cart",GlobalData.cart);
		return "cart";
	}
	
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index)
	{
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkOut(Model model)
	{
		model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		return "checkout";
	}
	
}
