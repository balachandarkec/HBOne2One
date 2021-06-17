package in.stack.one2oneDemo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_employee")
public class Employee {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String email;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="Account_Id")
 private Account account;


public Employee() {
	super();
}


public Employee(String name, String email, Account account) {
	super();
	this.name = name;
	this.email = email;
	this.account = account;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public Account getAccount() {
	return account;
}


public void setAccount(Account account) {
	this.account = account;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", account=" + account.toString() + "]";
}


 
 


}
