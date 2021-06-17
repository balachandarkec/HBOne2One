package in.stack.one2oneDemo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.stack.one2oneDemo.model.Account;
import in.stack.one2oneDemo.model.Employee;
import in.stack.one2oneDemo.util.HibernateUtil;

public class AccountDao {
	
	
	public void saveAccount(Account acc) {
		Transaction trans=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			session.save(acc);
			trans.commit();
			
		}catch(Exception e)
		{
				
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		
	}
	
	

	public void updateEmployee(Account acc) {
		Transaction trans=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			session.update(acc);
			trans.commit();
			
		}catch(Exception e)
		{
			
			
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		
	}
	
	
	
	
	
	

}
