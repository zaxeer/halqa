package org.ahmadiyya.halqa.software.ui;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.ahmadiyya.halqa.software.service.ReceiptService;
import org.ahmadiyya.halqa.software.ui.view.LoginView;
import org.ahmadiyya.halqa.software.ui.view.ReceiptEntryView;
import org.ahmadiyya.halqa.software.ui.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.WrappedSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
public class MyVaadinUI extends UI {

	private static final long serialVersionUID = 1L;
	private ApplicationContext applicationContext;
	
	@Autowired
	private ReceiptService repo;

	@Override
	protected void init(VaadinRequest request) {
		WrappedSession session = request.getWrappedSession();
		HttpSession httpSession = ((com.vaadin.server.WrappedHttpSession) session)
				.getHttpSession();
		ServletContext servletContext = httpSession.getServletContext();
		applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		Navigator navigator = new Navigator(this, this);
		navigator.addView("login", LoginView.class);
		navigator.addView("user", UserView.class);
		navigator.addView("main", ReceiptEntryView.class);
		navigator.navigateTo("login");
		setNavigator(navigator);
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public ReceiptService getRepo() {
		return repo;
	}

}
