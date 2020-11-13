package net.codejava.tags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import net.codejava.services.SlideService;



public class CarouseTag extends RequestContextAwareTag{
	private static final long serialVersionUID=1L;

	@Autowired
	private SlideService slideService;
	@Override
	protected int doStartTagInternal() throws Exception {
		if(slideService == null) {
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
			HttpServletRequest	request = (HttpServletRequest) pageContext.getRequest();
			request.setAttribute("slide", slideService.findAllWithStatus(true));
			String jspPage = "components/carouse_tag.jsp";
			request.getRequestDispatcher(jspPage);
			pageContext.include(jspPage);
		} catch (Exception e) {
			try {
				writer.write(e.getMessage());
			} catch (Exception e1) {
				
			}
		}
	}
	

}
