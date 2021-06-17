import in.stack.one2oneDemo.dao.EmployeeDao;
import in.stack.one2oneDemo.model.Account;
import in.stack.one2oneDemo.model.Employee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account acc=new Account("987654321");
		Account acc1=new Account("98765000");
		Employee emp=new Employee("Diwan","d@email.com",acc);
		Employee emp1=new Employee("anu","d@email.com",acc1);
		Employee emp2=new Employee("depak","d@email.com",acc);
		
		
		EmployeeDao empDAO=new EmployeeDao();
//		empDAO.savEmployee(emp);
//		empDAO.savEmployee(emp1);
//		empDAO.savEmployee(emp2);
//		
//		System.out.println();
//		
		
	 Employee test=empDAO.getEmployeeByID(3);
	 System.out.println(test.getAccount().toString());

	}

}
