package in.stack.one2oneDemo.util;



import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.hql.internal.CollectionProperties;
import org.hibernate.service.ServiceRegistry;

import in.stack.one2oneDemo.model.Account;
import in.stack.one2oneDemo.model.Employee;

public class HibernateUtil {
	

	
	public static SessionFactory getSessionFactory() {
		SessionFactory sf=null;
		 ServiceRegistry registry=null;
		if(sf==null) {
		try {
			// Hibernate Configuration
			
			Configuration cfg=new Configuration();
			Properties sestings=new Properties();
			
			sestings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			sestings.put(Environment.URL, "jdbc:mysql://localhost:3306/testDB");
			sestings.put(Environment.USER, "root");
			sestings.put(Environment.PASS, "root");
			sestings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			sestings.put(Environment.SHOW_SQL, "true");
			sestings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			sestings.put(Environment.POOL_SIZE, "2");
			sestings.put(Environment.HBM2DDL_AUTO, "update");
			
			cfg.setProperties(sestings);
			//Mapping the Entity Classes
			cfg.addAnnotatedClass(Account.class);
			cfg.addAnnotatedClass(Employee.class);
			
			 registry=new StandardServiceRegistryBuilder()
										.applySettings(cfg.getProperties()).build();
			System.out.println("Service Rigistry Created!");
			sf=cfg.buildSessionFactory(registry);
			
		}catch(Exception e) {
			e.printStackTrace();
			
			if(registry!=null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
		  }
		}
		
		return sf;
	}
	
	
	
	

}
