package net.codejava.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codejava.services.AccountService;
import net.codejava.services.CategoryService;
import net.codejava.services.InvoiceService;
import net.codejava.services.ProductService;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardController {
	
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ProductService productService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("countNewInvoices", invoiceService.countNewInvoices("pending"));
		modelMap.put("countProducts", productService.count());
		modelMap.put("countCustomers", accountService.countCustomer());
		modelMap.put("countCategory", categoryService.count());
		return "admin.dashboard.index";
	}
	
}

