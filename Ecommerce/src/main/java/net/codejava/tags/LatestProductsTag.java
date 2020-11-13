package net.codejava.tags;

import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import net.codejava.models.Category;
import net.codejava.models.Photo;
import net.codejava.models.Product;
import net.codejava.services.CategoryService;
import net.codejava.services.ProductService;

public class LatestProductsTag extends RequestContextAwareTag{
	private static final long serialVersionUID=1L;
	@Autowired
	private ProductService productService;

	@Override
	protected int doStartTagInternal() throws Exception {
		if(productService == null) {
			WebApplicationContext webApplicationContext=getRequestContext().getWebApplicationContext();
			AutowireCapableBeanFactory autowireCapableBeanFactory= webApplicationContext.getAutowireCapableBeanFactory();
			autowireCapableBeanFactory.autowireBean(this);
		}
		return SKIP_BODY;
	}
	@Override
	public void doFinally() {
		JspWriter writer = pageContext.getOut();
	try {
		writer.write("<ul id=\"sideManu\" class=\"nav nav-tabs nav-stacked\">");
		List<Product> products = productService.latestProducts(true, 2);
		if(products != null) {
			 
			for(Product product : products) {
				Photo photo=product.getPhotos().stream().filter(p -> p.isStatus() && p.isMain()).findFirst().get();
				writer.write("<div class=\"thumbnail\">");
				writer.write("<img src=\"" + getRequestContext().getContextPath()+ "/uploads/images/" + photo.getName() + "\" />");
				writer.write("<div class=\"caption\">");
				writer.write("<h5>"+product.getName()+"</h5>");
				writer.write("<h4 style=\"text-align: center\">");
				writer.write("<a class='btn' href='"+pageContext.getServletContext().getContextPath()+ "/product/details/" + product.getId() +"'> <i\r\n" + "class=\"icon-zoom-in\"></i></a>");
				writer.write("<a class='btn' href='"+pageContext.getServletContext().getContextPath()+ "/cart/buy/"  + product.getId() + "'>Add to <i class=\"icon-shopping-cart\"></i></a>");
				writer.write("<a class='btn btn-primary' href=\"#\">$"+product.getPrice()+"</a>");
				writer.write("</h4>");
				writer.write("</div>");
				writer.write("</div>");
			}
		}
		
	} catch (Exception e) {
		try {
			writer.write(e.getMessage());
		} catch (Exception e1) {
			
		}
		
	}
	}

	
}
