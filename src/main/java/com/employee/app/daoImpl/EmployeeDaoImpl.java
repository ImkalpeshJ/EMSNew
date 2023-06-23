package com.employee.app.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.app.dao.EmployeeDao;
import com.employee.app.entity.Employee;
import com.employee.app.entity.Status;

@SuppressWarnings({ "deprecation", "unchecked", "unused" })
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean postEmployee(Employee employee) {
		Session session = null;
		boolean isAdded = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sf.openSession();
		List<Employee> list = null;
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Session session = null;
		boolean isUpdated = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Employee dbEmployee = getEmployeeById(employee.getId());
			if (dbEmployee != null) {
				employee.setCreatedBy(dbEmployee.getCreatedBy());
				employee.setCreatedDate(dbEmployee.getCreatedDate());
				session.update(employee);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {

		} finally {
			if (session != null)
				session.close();
		}
		return isDeleted;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Session session = null;
		Employee employee = null;
		try {
			session = sf.openSession();
			employee = session.get(Employee.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return employee;
	}

	@Override
	public List<Employee> getEmployeeByStatus(Status status) {
		Session session = null;
		List<Employee> employees = null;
		try {
			session = sf.openSession();
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);

			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("status"), status));
			TypedQuery<Employee> query = session.createQuery(criteriaQuery);
			employees = query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return employees;
	}

}
