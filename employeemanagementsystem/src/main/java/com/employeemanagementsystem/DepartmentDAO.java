package com.employeemanagementsystem;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DepartmentDAO {

    public void saveDepartmentWithEmployees(Department department, List<Employee> employees) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            for (Employee employee : employees) {
                employee.setDepartment(department);
                department.addEmployee(employee);
            }
            entityManager.persist(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public Department getDepartment(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        Department department = null;
        try {
            department = entityManager.find(Department.class, id);
        } finally {
            entityManager.close();
        }
        return department;
    }

    public List<Department> getAllDepartments() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Department> departments = null;
        try {
            departments = entityManager.createQuery("from Department", Department.class).getResultList();
        } finally {
            entityManager.close();
        }
        return departments;
    }

    public void updateDepartment(Department department) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void deleteDepartment(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Department department = entityManager.find(Department.class, id);
            if (department != null) {
                entityManager.remove(department);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
