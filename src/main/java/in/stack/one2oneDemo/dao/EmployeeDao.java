package in.stack.one2oneDemo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.stack.one2oneDemo.model.Employee;
import in.stack.one2oneDemo.util.HibernateUtil;

public class EmployeeDao {
	
	
	public void savEmployee(Employee emp) {
		Transaction trans=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			session.save(emp);
			trans.commit();
			
		}catch(Exception e)
		{
				
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		
	}
	
	
	public void updateEmployee(Employee emp) {
		Transaction trans=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			session.update(emp);
			trans.commit();
			
		}catch(Exception e)
		{
			
			
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		
	}
	
//Delete Employee
	

	public void deleteupdateEmployee(int id) {
		Transaction trans=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			
			Employee target=session.get(Employee.class,id);
			if(target!=null) {
				session.delete(target);
				
				System.out.println("Employee ID "+id+" deleted Successfully");
				
			}
			
			trans.commit();
			
		}catch(Exception e)
		{
			
			
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		
	}
	
	
	

	public Employee getEmployeeByID(int id) {
		Transaction trans=null;
		Employee target=null; 
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			trans =session.beginTransaction();
			
			target=session.get(Employee.class,id);
			
			
			
		}catch(Exception e)
		{
			
			
			if(trans!=null) {
				trans.rollback();
			}
			e.printStackTrace();
		}

		return target;
	}
	
	
	
	
	

}
