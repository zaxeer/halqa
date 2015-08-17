package org.ahmadiyya.halqa.software.config;

import org.ahmadiyya.halqa.software.service.AuthManager;
import org.ahmadiyya.halqa.software.service.ReceiptService;
import org.ahmadiyya.halqa.software.service.ReceiptServiceImpl;
import org.ahmadiyya.halqa.software.ui.listener.LoginFormListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class BeanConfig {

	@Bean
	public AuthManager authManager() {
		return new AuthManager();
	}

//	@Bean
//	public ReceiptServiceImpl receiptService() {
//		return new ReceiptServiceImpl();
//	}

	@Bean
	public LoginFormListener loginFormListener() {
		return new LoginFormListener();
	}
}
