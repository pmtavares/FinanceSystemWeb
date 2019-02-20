package com.financial.test;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.finance.util.HibernateUtil;

//@RunWith(SpringRunner.class)
//@SpringBootTest(properties = "spring.profiles.active=test")
//@AutoConfigureMockMvc
public class HibernateUtilTest {

	@Test
	@Ignore
    public void testMe() {
        System.out.println("Hello World!");
    }
	
	@Test
	@Ignore
	public void connect(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.close();
		HibernateUtil.getSessionFactory().close();
	} 
}
