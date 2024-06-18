package com.employeemanagementsystem;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {

	private static EmployeeDAO employeeDAO = new EmployeeDAO();
	private static DepartmentDAO departmentDAO = new DepartmentDAO();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Employee Management System");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. List Employees");
			System.out.println("4. Delete Employee");
			System.out.println("5. Add Department");
			System.out.println("6. Update Department");
			System.out.println("7. List Departments");
			System.out.println("8. Delete Department");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addEmployee(scanner);
				break;
			case 2:
				updateEmployee(scanner);
				break;
			case 3:
				listEmployees();
				break;
			case 4:
				deleteEmployee(scanner);
				break;
			case 5:
				addDepartment(scanner);
				break;
			case 6:
				updateDepartment(scanner);
				break;
			case 7:
				listDepartments();
				break;
			case 8:
				deleteDepartment(scanner);
				break;
			case 9:
				System.out.println("Exiting...");
				return;
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	private static void addEmployee(Scanner scanner) {
		System.out.print("Enter employee name: ");
		String name = scanner.nextLine();
		System.out.print("Enter employee salary: ");
		double salary = scanner.nextDouble();
		System.out.print("Enter department id: ");
		int deptId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Department department = departmentDAO.getDepartment(deptId);
		if (department == null) {
			System.out.println("Department not found!");
			return;
		}

		Employee employee = new Employee();
		employee.setName(name);
		employee.setSalary(salary);
		employee.setDepartment(department);
		employeeDAO.saveEmployee(employee);
		System.out.println("Employee added successfully!");
	}

	private static void updateEmployee(Scanner scanner) {
		System.out.print("Enter employee id: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Employee employee = employeeDAO.getEmployee(id);
		if (employee == null) {
			System.out.println("Employee not found!");
			return;
		}

		System.out.print("Enter new employee name: ");
		String name = scanner.nextLine();
		System.out.print("Enter new employee salary: ");
		double salary = scanner.nextDouble();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter new department id: ");
		int deptId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Department department = departmentDAO.getDepartment(deptId);
		if (department == null) {
			System.out.println("Department not found!");
			return;
		}

		employee.setName(name);
		employee.setSalary(salary);
		employee.setDepartment(department);
		employeeDAO.updateEmployee(employee);
		System.out.println("Employee updated successfully!");
	}

	private static void listEmployees() {
		List<Employee> employees = employeeDAO.getAllEmployees();
		System.out.println("ID \t Name \t Salary \tDepartment");
		for (Employee employee : employees) {
			System.out.println(
					employee.getId() + "\t" + employee.getName() + "\t" + employee.getSalary()+ "\t" + employee.getDepartment().getName());
		}
	}

	private static void deleteEmployee(Scanner scanner) {
		System.out.print("Enter employee id: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		employeeDAO.deleteEmployee(id);
		System.out.println("Employee deleted successfully!");
	}

	private static void addDepartment(Scanner scanner) {
		System.out.print("Enter department name: ");
		String name = scanner.nextLine();

		Department department = new Department();
		department.setName(name);
		departmentDAO.saveDepartment(department);
		System.out.println("Department added successfully!");
	}

	private static void updateDepartment(Scanner scanner) {
		System.out.print("Enter department id: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Department department = departmentDAO.getDepartment(id);
		if (department == null) {
			System.out.println("Department not found!");
			return;
		}

		System.out.print("Enter new department name: ");
		String name = scanner.nextLine();
		department.setName(name);
		departmentDAO.updateDepartment(department);
		System.out.println("Department updated successfully!");
	}

	private static void listDepartments() {
		List<Department> departments = departmentDAO.getAllDepartments();
		System.out.println("ID  \t  Name ");
		for (Department department : departments) {
			System.out.println(department.getId() + "\t" + department.getName());
		}
	}

	private static void deleteDepartment(Scanner scanner) {
		System.out.print("Enter department id: ");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		departmentDAO.deleteDepartment(id);
		System.out.println("Department deleted successfully!");
	}
}
