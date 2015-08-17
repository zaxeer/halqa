package org.ahmadiyya.halqa.software.ui.listener;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.*;

import org.ahmadiyya.halqa.software.service.AuthManager;
import org.ahmadiyya.halqa.software.ui.MyVaadinUI;
import org.ahmadiyya.halqa.software.ui.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoginFormListener implements Button.ClickListener {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AuthManager authManager;

	@Override
	public void buttonClick(Button.ClickEvent event) {
		try {
			Button source = event.getButton();
			LoginForm parent = (LoginForm) source.getParent();
			String username = parent.getTxtLogin().getValue();
			String password = parent.getTxtPassword().getValue();
			UsernamePasswordAuthenticationToken request = new UsernamePasswordAuthenticationToken(
					username, password);
			Authentication result = authManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			MyVaadinUI current = (MyVaadinUI) UI.getCurrent();
			Navigator navigator = current.getNavigator();
			navigator.navigateTo("main");
		} catch (AuthenticationException e) {
			Notification.show("Authentication failed: " + e.getMessage());
		}
	}
}
