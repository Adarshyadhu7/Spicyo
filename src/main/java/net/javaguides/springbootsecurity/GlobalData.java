package net.javaguides.springbootsecurity;

import java.util.ArrayList;
import java.util.List;

import net.javaguides.springbootsecurity.entities.Product;

public class GlobalData {
	
	public static List<Product> cart;
	
	static
	{
		cart = new ArrayList<Product>();
	}
		
}
