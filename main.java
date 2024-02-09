package firstProject;

import java.util.ArrayList;

abstract class Employee {
	private String name;
	private int id;
	public Employee (int id,String name) {
		this.id=id;
		this.name=name;
	}
	public String getname() {
		return name;
	}
	public int getId() {
		return id;
	}
	public abstract double calculateSalary();
	
	public String toString() {
		return "Employee[name="+name+", id="+id+", Salary="+ calculateSalary()+"]";
	}
}
class FullTimeEmployee extends Employee{
	private double monthlySalary;
	public FullTimeEmployee(int id, String name,double monthlySalary) {
		super(id, name);
		this.monthlySalary=monthlySalary;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double calculateSalary() {
		return monthlySalary;
	}
	
	
}
class partTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;
	public  partTimeEmployee(int id,String name,int hoursWorked,double hourlyRate) {
		super(id,name);
		this.hoursWorked=hoursWorked;
		this.hourlyRate=hourlyRate;
}
	@Override
	public double calculateSalary() {
		return hoursWorked*hourlyRate;
	}
}
	class payrollSystem{
		private ArrayList<Employee> employeeList;
		public payrollSystem() {
			employeeList=new ArrayList<>();
		}
		public void addEmployee(Employee employee) {
			employeeList.add(employee);
		}
		public void removeEmployee(int id) {
			employeeList.removeIf((Employee)->Employee.getId()==id);
		}
		public void displayEmployees() {
			for(Employee e:employeeList) {
				System.out.println(e);;
			}
		}
	}
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		payrollSystem ps=new payrollSystem();
		System.out.println("Adding Employess---------");
		ps.addEmployee(new FullTimeEmployee(1,"Jashwanth",70000));
		ps.addEmployee(new partTimeEmployee(2,"anantha",15, 2000));
		ps.addEmployee(new FullTimeEmployee(3,"krishna",50000));
		ps.addEmployee(new partTimeEmployee(4,"bhanu",20, 1000));
		ps.displayEmployees();
		System.out.println("Removing Employess---------");
		ps.removeEmployee(3);
		ps.removeEmployee(4);
		ps.displayEmployees();
	}

}
