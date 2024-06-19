package com.employeemanagementsystem;



import java.util.ArrayList;
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
            System.out.println("5. Add Department with Employees");
            System.out.println("6. Update Department");
            System.out.println("7. List Departments");
            System.out.println("8. Delete Department");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

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
                    addDepartmentWithEmployees(scanner);
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
        scanner.nextLine();  // Consume newline

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
        scanner.nextLine();  // Consume newline

        Employee employee = employeeDAO.getEmployee(id);
        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter new department id: ");
        int deptId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

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
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() + ", Salary: " + employee.getSalary() + ", Department: " + (employee.getDepartment() != null ? employee.getDepartment().getName() : "No Department"));
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        employeeDAO.deleteEmployee(id);
        System.out.println("Employee deleted successfully!");
    }

    private static void addDepartmentWithEmployees(Scanner scanner) {
        System.out.print("Enter department name: ");
        String deptName = scanner.nextLine();

        System.out.print("How many employees to add in this department? ");
        int empCount = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < empCount; i++) {
            System.out.print("Enter employee name: ");
            String empName = scanner.nextLine();
            System.out.print("Enter employee salary: ");
            double empSalary = scanner.nextDouble();
            scanner.nextLine();  // Consume newline

            Employee employee = new Employee();
            employee.setName(empName);
            employee.setSalary(empSalary);
            employees.add(employee);
        }

        Department department = new Department();
        department.setName(deptName);

        departmentDAO.saveDepartmentWithEmployees(department, employees);
        System.out.println("Department and employees added successfully!");
    }

    private static void updateDepartment(Scanner scanner) {
        System.out.print("Enter department id: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

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
        for (Department department : departments) {
            System.out.println("ID: " + department.getId() + ", Name: " + department.getName());
        }
    }

    private static void deleteDepartment(Scanner scanner) {
        System.out.print("Enter department id: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        departmentDAO.deleteDepartment(id);
        System.out.println("Department deleted successfully!");
    }
}
