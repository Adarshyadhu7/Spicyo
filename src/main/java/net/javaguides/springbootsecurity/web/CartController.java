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
//		GlobalData.cart.add(products.getProductsById(id).get());
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
	
}
