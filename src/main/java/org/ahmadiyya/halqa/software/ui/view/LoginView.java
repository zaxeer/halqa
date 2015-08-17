package org.ahmadiyya.halqa.software.ui.view;

import org.ahmadiyya.halqa.software.ui.form.LoginForm;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public LoginView() {
		LoginForm loginForm = new LoginForm();
		addComponent(loginForm);
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
	}
}
