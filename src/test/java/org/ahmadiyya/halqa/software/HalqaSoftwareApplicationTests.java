package org.ahmadiyya.halqa.software;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HalqaSoftwareApplication.class)
@WebAppConfiguration
public class HalqaSoftwareApplicationTests {
	
	@Autowired
	UserDetailsService service;

	

}
