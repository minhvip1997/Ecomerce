package net.codejava.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codejava.models.Product;
import net.codejava.services.ProductService;

@Controller
@RequestMapping(value= {"","home"})
public class HomeController {
	@Autowired
	private ProductService productService;
	@RequestMapping( method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("isHome", true);
		modelMap.put("featuredProducts", productService.featuredProducts(true,true, 6));
		modelMap.put("latestProducts", productService.latestProducts(true, 6));
		return "home.index";
	}
}
