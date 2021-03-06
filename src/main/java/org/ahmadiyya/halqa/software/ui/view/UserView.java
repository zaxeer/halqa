package org.ahmadiyya.halqa.software.ui.view;

import java.util.Collection;

import org.ahmadiyya.halqa.software.ui.listener.LogoutListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UserView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	@Override
	public void enter(ViewChangeEvent event) {
		removeAllComponents();
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication != null && authentication.isAuthenticated()) {
			String name = authentication.getName();
			Label labelLogin = new Label("Username: " + name);
			addComponent(labelLogin);
			Collection<? extends GrantedAuthority> authorities = authentication
					.getAuthorities();
			for (GrantedAuthority ga : authorities) {
				String authority = ga.getAuthority();
				if ("ADMIN".equals(authority)) {
					Label lblAuthority = new Label(
							"You are the administrator. ");
					addComponent(lblAuthority);
				} else {
					Label lblAuthority = new Label("Granted Authority: "
							+ authority);
					addComponent(lblAuthority);
				}
			}
			Button logout = new Button("Logout");
			LogoutListener logoutListener = new LogoutListener();
			logout.addClickListener(logoutListener);
			addComponent(logout);
		} else {
			Navigator navigator = UI.getCurrent().getNavigator();
			navigator.navigateTo("login");
		}

	}

}
