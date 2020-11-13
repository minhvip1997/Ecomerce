package net.codejava.controllers.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("customer-panel")
public class LoginCustomerController {
	
	@RequestMapping(value= {"","index"},method=RequestMethod.GET)
	public String index() {
		return "redirect:/customer-panel/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout,ModelMap modelmap) {
		if(error!=null) {
			modelmap.put("msg", "Invalid username or password");
		}
		if(logout!=null) {
			modelmap.put("msg", "Logout Successful");
		}
		return "customer.login.index";
	}
	
	@RequestMapping(value="process",method=RequestMethod.POST)
	public String process() {
		return "redirect:/admin/dashboard";
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout() {
		return "redirect:/customer-panel/login?logout";
	}
	@RequestMapping(value="accessDenied",method=RequestMethod.GET)
	public String accessDenied(Authentication authentication,ModelMap modelMap) {
		if(authentication !=null) {
			modelMap.put("msg", "Hi"+authentication.getName()+", you do not have permission to access this page");
		}else {
			modelMap.put("msg", "You do not have permission to access this page");
		}
		return "customer.login.accessDenied";
	}
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public String welcome() {
		return "redirect:/customer/dashboard";
	}
}
