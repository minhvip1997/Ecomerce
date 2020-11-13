package net.codejava.tags;

import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import net.codejava.models.Category;
import net.codejava.services.CategoryService;

public class CategoryListTag extends RequestContextAwareTag {

	private static final long serialVersionUID=1L;
	@Autowired
	private CategoryService categoryService;

	@Override
	protected int doStartTagInternal() throws Exception {
		if(categoryService == null) {
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
		List<Category> categories=categoryService.findParentCategoriesWithStatus(true);
		if(categories != null) {
			for(Category category : categories) {
				writer.write("<li class=\"subMenu\"><a href='#'>"+category.getName()+"</a>");
				if(!category.getCategories().isEmpty()) {
					writer.write("<ul style=\"display: none\">");
					for(Category subCategory : category.getCategories()) {
						writer.write("<li><a href='"+pageContext.getServletContext().getContextPath()+"/product/category/"+subCategory.getId()+"'>"
								+ "<i class=\"icon-chevron-right\"></i>"+subCategory.getName()+"</a></li>");
					}
					writer.write("</ul>");
				}
				writer.write("<li />");
			}
		}
		writer.write("</ul>");
	} catch (Exception e) {
		try {
			writer.write(e.getMessage());
		} catch (Exception e1) {
			
		}
		
	}
	}

	

}
