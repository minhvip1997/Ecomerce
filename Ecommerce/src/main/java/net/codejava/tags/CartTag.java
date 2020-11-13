package net.codejava.tags;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import net.codejava.models.Category;
import net.codejava.models.Item;
import net.codejava.services.CategoryService;

public class CartTag extends RequestContextAwareTag {

	private static final long serialVersionUID = 1L;

	@Override
	protected int doStartTagInternal() throws Exception {

		return SKIP_BODY;
	}

	@Override
	public void doFinally() {
		JspWriter writer = pageContext.getOut();
		try {
			HttpSession session=pageContext.getSession();
			int countItems=0;
			double total=0;
			if(session.getAttribute("cart") !=null) {
				List<Item> cart=(List<Item>) session.getAttribute("cart");
				countItems=cart.size();
				for(Item item:cart) {
					total+=item.getProduct().getPrice()*item.getQuantity();
				}
			}
			writer.write("<a id='myCart' href='"+pageContext.getServletContext().getContextPath()+"/cart/index'>");
			writer.write("<img src='"+pageContext.getServletContext().getContextPath()+"/resources/user/themes/images/ico-cart.png'alt='cart'>");
			writer.write(countItems +" Items in your cart ");
			writer.write("<span class='badge badge-warning pull-right'>$"+total+"</span>");
			writer.write("</a>");
		} catch (Exception e) {
			try {
				writer.write(e.getMessage());
			} catch (Exception e1) {

			}

		}
	}

}
