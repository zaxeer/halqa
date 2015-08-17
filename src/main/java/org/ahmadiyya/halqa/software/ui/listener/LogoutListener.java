package org.ahmadiyya.halqa.software.ui.listener;

import org.springframework.security.core.context.SecurityContextHolder;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

public class LogoutListener implements Button.ClickListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void buttonClick(Button.ClickEvent clickEvent) {
		SecurityContextHolder.clearContext();
		UI.getCurrent().close();
		Navigator navigator = UI.getCurrent().getNavigator();
		navigator.navigateTo("login");
	}

}
