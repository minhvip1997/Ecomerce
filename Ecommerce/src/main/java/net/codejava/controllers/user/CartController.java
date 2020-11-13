package net.codejava.controllers.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.models.Category;
import net.codejava.models.Invoice;
import net.codejava.models.InvoiceDetails;
import net.codejava.models.InvoiceDetailsId;
import net.codejava.models.Item;
import net.codejava.models.Product;
import net.codejava.services.AccountService;
import net.codejava.services.CategoryService;
import net.codejava.services.InvoiceDetailsService;
import net.codejava.services.InvoiceService;
import net.codejava.services.ProductService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceDetailsService invoiceDetailsService;
	@Autowired
	private AccountService accountService;
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpSession session,ModelMap modelMap) {
		int countItems=0;
		double total=0;
		if(session.getAttribute("cart") !=null) {
			List<Item> cart=(List<Item>) session.getAttribute("cart");
			countItems=cart.size();
			for(Item item:cart) {
				total+=item.getProduct().getPrice()*item.getQuantity();
			}
		}
		modelMap.put("countItems",countItems);
		modelMap.put("total",total);
		return "cart.index";
	}

	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") int id,HttpSession session) {
		if(session.getAttribute("cart") == null) {
			List<Item> cart=new ArrayList<Item>();
			cart.add(new Item(productService.find(id),1));
			session.setAttribute("cart", cart);
		}else {
			List<Item> cart=(List<Item>) session.getAttribute("cart");
			int index = exists(id, cart);
			if(index==-1) {
				cart.add(new Item(productService.find(id),1));
			}else {
				int newQuantity=cart.get(index).getQuantity()+1;
				cart.get(index).setQuantity(newQuantity);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/cart/index";
	}

	@RequestMapping(value = "remove/{index}", method = RequestMethod.GET)
	public String remove(@PathVariable("index") int index,HttpSession session) {
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@RequestParam("quantities") int[] quantities,HttpSession session) {
		
		if(session.getAttribute("cart") !=null) {
			List<Item> cart=(List<Item>) session.getAttribute("cart");
			for(int i=0;i<cart.size();i++) {
				cart.get(i).setQuantity(quantities[i]);
			}
			session.setAttribute("cart", cart);
		}
		
		return "redirect:/cart/index";
	}
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public String checkout(Authentication authentication,HttpSession session) {
		if(authentication == null) {
			return "redirect:/customer-panel";
		}else {
			if(session.getAttribute("cart") !=null) {
				
				Invoice invoice=new Invoice();
				invoice.setAccount(accountService.findByUsername(authentication.getName()));
				invoice.setCreated(new Date());
				invoice.setName("New Invoice");
				invoice.setStatus("pending");
				invoice=invoiceService.save(invoice);
				
				List<Item> cart=(List<Item>) session.getAttribute("cart");
				for(Item item : cart) {
					InvoiceDetails invoiceDetails = new InvoiceDetails();
					invoiceDetails.setId(new InvoiceDetailsId(invoice.getId(),item.getProduct().getId()));
					invoiceDetails.setPrice(item.getProduct().getPrice());
					invoiceDetails.setQuantity(item.getQuantity());
					invoiceDetailsService.save(invoiceDetails);
				}
				session.removeAttribute("cart");
			}
			
			return "cart.thanks";
		}
		
	}
	private int exists(int id,List<Item> cart) {
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getProduct().getId() ==id) {
				return i;
			}
		}
		return -1;
	}

}
