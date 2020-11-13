package net.codejava.controllers.user;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.models.Category;
import net.codejava.models.Product;
import net.codejava.services.CategoryService;
import net.codejava.services.ProductService;
@Controller
@RequestMapping(value= "/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@RequestMapping( value="details/{id}", method = RequestMethod.GET)
	public String details(@PathVariable("id") int id,ModelMap modelMap) {
		Product product = productService.find(id);
	modelMap.put("product", productService.find(id));
	modelMap.put("photos", product.getPhotos().stream().filter(p -> p.isStatus()).collect(Collectors.toList()));
	modelMap.put("relatedProducts", productService.relatedProducts(true, product.getCategorys().getId(), product.getId(), 6));
		return "product.details";
	}
	@RequestMapping( value="category/{id}", method = RequestMethod.GET)
	public String category(@PathVariable("id") int id,HttpServletRequest request,ModelMap modelMap) {
		Category category = categoryService.find(id);
		PagedListHolder pagedListHolder=new PagedListHolder(category.getProducts());
		int page= ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(2);
		modelMap.put("pagedListHolder", pagedListHolder);
		modelMap.put("category", category);
		return "product.category";
	}
	@RequestMapping( value="search", method = RequestMethod.POST)
	public String search(@RequestParam("keyword") String keyword,
			@RequestParam("category") int category,HttpServletRequest request,ModelMap modelMap) {
		PagedListHolder pagedListHolder=null;
		if(category==-1) {
			pagedListHolder=new PagedListHolder(productService.searchAll(true, keyword));
		}else {
			pagedListHolder=new PagedListHolder(productService.searchByCategory(true, keyword, category));
		}
		
		int page= ServletRequestUtils.getIntParameter(request, "p", 0);
		pagedListHolder.setPage(page);
		pagedListHolder.setPageSize(9);
		modelMap.put("pagedListHolder", pagedListHolder);
		modelMap.put("keyword", keyword);
		return "product.search";
	}
}
