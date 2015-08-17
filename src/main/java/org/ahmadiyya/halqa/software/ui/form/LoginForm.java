package org.ahmadiyya.halqa.software.ui.form;

import org.ahmadiyya.halqa.software.ui.MyVaadinUI;
import org.ahmadiyya.halqa.software.ui.listener.LoginFormListener;
import org.springframework.context.ApplicationContext;

import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LoginForm extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private TextField txtLogin = new TextField("Login: ");
	private PasswordField txtPassword = new PasswordField("Password: ");
	private Button btnLogin = new Button("Login");

	public LoginForm() {
		addComponent(txtLogin);
		addComponent(txtPassword);
		addComponent(btnLogin);
		LoginFormListener loginFormListener = getLoginFormListener();
		btnLogin.addClickListener(loginFormListener);
	}

	public LoginFormListener getLoginFormListener() {
		MyVaadinUI ui = (MyVaadinUI) UI.getCurrent();
		ApplicationContext context = ui.getApplicationContext();
		return context.getBean(LoginFormListener.class);
	}

	public TextField getTxtLogin() {
		return txtLogin;
	}

	public PasswordField getTxtPassword() {
		return txtPassword;
	}
}
