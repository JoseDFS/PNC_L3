package com.uca.inventaroProducto.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.inventaroProducto.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/productos")
	public ModelAndView listado() {
		ModelAndView mv = new ModelAndView();
		
		productos.add(new Product(0,"The Witcher 3","43"));
		productos.add(new Product(1,"TLOZ SS","83"));
		productos.add(new Product(2,"Hollow Knight","200"));
		
		
		mv.setViewName("producto");
		mv.addObject("product", new Product());
		mv.addObject("producto",productos);
		
		
		return mv;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto) {
		ModelAndView mv = new ModelAndView();
		int cantI = Integer.parseInt(productos.get(producto.getId()).getCantidad());
		int cantD = Integer.parseInt(producto.getCantidad());
		if(cantD > cantI) {
			mv.addObject("error", productos.get(producto.getId()).getNombre() );
			mv.setViewName("error");
		}
		else {
			mv.addObject("compra", productos.get(producto.getId()).getNombre() );
			mv.setViewName("exito");
		}
		return mv;
}
	}

